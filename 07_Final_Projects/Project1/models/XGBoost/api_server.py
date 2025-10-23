import os
import joblib
from konlpy.tag import Okt
from flask import Flask, request, jsonify
import numpy as np
from flask_cors import CORS

# --- Flask 앱 생성 ---
app = Flask(__name__)
CORS(app, origins=["https://interest-56pc.onrender.com"])

# --- 헬스 체크 (Render Health Check용) ---
@app.route("/")
def home():
    return "✅ Flask server is running"

# --- 모델 로드 ---햣
print("🚀 모델과 도구들을 불러오는 중입니다...")
try:
    model = joblib.load("./korean_topic_model.pkl")
    vectorizer = joblib.load("./tfidf_vectorizer.pkl")
    label_encoder = joblib.load("./label_encoder.pkl")
    print("✅ 모델과 도구 로딩 완료.")
except FileNotFoundError:
    print("❌ 오류: 저장된 모델 파일(.pkl)을 찾을 수 없습니다.")
    # 모델 파일이 없을 경우 Render가 서버를 멈추지 않게 예외처리
    model, vectorizer, label_encoder = None, None, None

# --- 예측 수행 ---
@app.route("/predict", methods=["POST"])
def predict():
    try:
        data = request.get_json()
        user_input = data.get("sentence", "").strip()

        if not user_input:
            return jsonify({"error": "sentence 키가 없거나 문장이 비어있습니다."}), 400

        # 모델이 없는 경우 예외 처리 (Render가 중단되지 않게)
        if model is None or vectorizer is None or label_encoder is None:
            print("⚠️ 모델이 로드되지 않아 더미 데이터 반환 중")
            dummy_scores = {
                "영화/미디어": 30,
                "스포츠": 20,
                "경제/재테크": 10,
                "기술/IT": 25,
                "일상/여행": 15
            }
            return jsonify({"scores": dummy_scores}), 200

        # 입력 문장 전처리
        sentences = [s.strip() for s in user_input.replace(",", ".").split(".") if s.strip()]
        processed_input = user_input
        if len(sentences) > 1:
            last_sentence = sentences[-1]
            processed_input = user_input + " " + (last_sentence + " ") * 2

        # --- 예측 수행 ---
        input_vec = vectorizer.transform([processed_input])
        probabilities = model.predict_proba(input_vec)[0]

        # NumPy float → Python float 변환
        scores_dict = {
            topic: round(float(prob) * 100, 2)
            for topic, prob in zip(label_encoder.classes_, probabilities)
        }

        print("✅ Flask 예측 성공:", scores_dict)
        return jsonify({"scores": scores_dict})

    except Exception as e:
        print("❌ Flask 예측 중 오류:", e)
        return jsonify({"error": "예측 처리 중 오류 발생", "message": str(e)}), 500


# --- Flask 실행 (Render 포트 자동 설정) ---
if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))  # Render 환경변수 PORT 사용
    app.run(host="0.0.0.0", port=port, debug=False)