import os
import re
import joblib
from flask import Flask, request, jsonify
from flask_cors import CORS

# --- Flask 앱 생성 ---
app = Flask(__name__)
CORS(app, origins=["https://interest-56pc.onrender.com"])

# === 모델 전역 변수 (지연 로딩용) ===
model = None
vectorizer = None
label_encoder = None


# === 간단한 토크나이저 (Okt 제거, JVM 미사용) ===
def simple_tokenize(text):
    return re.findall(r"[가-힣]+", text)


# === Lazy Load 모델 ===
def load_models():
    global model, vectorizer, label_encoder
    if model is None:
        print("📦 모델 로딩 중...")
        model = joblib.load("./korean_topic_model.pkl")
        vectorizer = joblib.load("./tfidf_vectorizer.pkl")
        label_encoder = joblib.load("./label_encoder.pkl")
        print("✅ 모델 로드 완료.")


# === 예측 수행 API ===
@app.route("/predict", methods=["POST"])
def predict():
    try:
        data = request.get_json()
        user_input = data.get("sentence", "").strip()

        if not user_input:
            return jsonify({"error": "sentence 키가 없거나 문장이 비어 있습니다."}), 400

        # 모델 지연 로드
        load_models()

        # 입력 전처리
        tokens = simple_tokenize(user_input)
        joined_text = " ".join(tokens)

        # TF-IDF 변환
        input_vec = vectorizer.transform([joined_text])

        # 예측 수행
        probabilities = model.predict_proba(input_vec)[0]

        # 결과 변환 (float32 → float)
        scores_dict = {
            topic: round(float(prob) * 100, 2)
            for topic, prob in zip(label_encoder.classes_, probabilities)
        }

        return jsonify({"scores": scores_dict})

    except Exception as e:
        print(f"❌ 오류 발생: {e}")
        return jsonify({"error": str(e)}), 500


# === 서버 실행 ===
if __name__ == "__main__":
    port = int(os.environ.get("PORT", 5000))
    app.run(host="0.0.0.0", port=port, debug=False)