import joblib
from konlpy.tag import Okt
from flask import Flask, request, jsonify
import numpy as np # numpy를 임포트하면 더 안정적입니다.
from flask_cors import CORS
from topic_utils import tokenize
import os

# --- Flask 앱 생성 ---
app = Flask(__name__)
CORS(app, origins=["https://interest-56pc.onrender.com"])

@app.route('/api/get-topic', methods=['POST'])
def analyze_topic():
    data = request.get_json()
    sentence = data.get('sentence', '')
    # 예시: 더미 데이터 반환
    return jsonify({
        "scores": {
            "영화/미디어": 30,
            "스포츠": 20.0,
            "경제/재테크": 10.0,
            "기술/IT": 25.0,
            "일상/여행": 14.5,
            "기타_주제" : 0.5
        }
    })

# --- 2. 학습 때와 동일한 토크나이저 함수 정의 ---
# okt = Okt()
# def tokenize(text):
#     return [word for word, pos in okt.pos(text, stem=True) if pos in ['Noun', 'Verb', 'Adjective']]

# --- 1. 모델과 필요 도구를 미리 불러오기 ---
print("🚀 모델과 도구들을 불러오는 중입니다...")
try:
    model = joblib.load('./korean_topic_model.pkl')
    vectorizer = joblib.load('./tfidf_vectorizer.pkl')
    label_encoder = joblib.load('./label_encoder.pkl')
    print("✅ 모델과 도구 로딩 완료.")
except FileNotFoundError:
    print("❌ 오류: 저장된 모델 파일(.pkl)을 찾을 수 없습니다.")
    exit()

# --- 3. 예측을 수행할 API 엔드포인트 정의 ---
@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    user_input = data.get('sentence')
    
    if not user_input or not user_input.strip():
        return jsonify({'error': 'sentence 키가 없거나 문장이 비어있습니다.'}), 400

    sentences = [s.strip() for s in user_input.replace(',', '.').split('.') if s.strip()]
    processed_input = user_input
    if len(sentences) > 1:
        last_sentence = sentences[-1]
        processed_input = user_input + " " + (last_sentence + " ") * 2
    
    # --- 예측 수행 ---
    input_vec = vectorizer.transform([processed_input])
    probabilities = model.predict_proba(input_vec)[0]

    # ✨ 수정된 부분: NumPy float를 Python float으로 변환
    scores_dict = {
        topic: round(float(prob) * 100, 2) 
        for topic, prob in zip(label_encoder.classes_, probabilities)
    }

    return jsonify({'scores': scores_dict})

# --- 4. API 서버 실행 ---
if __name__ == '__main__':
    port = int(os.environ.get("PORT", 5000))
    app.run(host='0.0.0.0', port=port, debug=False)