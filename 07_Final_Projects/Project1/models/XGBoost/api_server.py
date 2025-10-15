import joblib
from konlpy.tag import Okt
from flask import Flask, request, jsonify

# --- Flask 앱 생성 ---
app = Flask(__name__)

# --- 2. 학습 때와 동일한 토크나이저 함수 정의 ---
okt = Okt()
def tokenize(text):
    return [word for word, pos in okt.pos(text, stem=True) if pos in ['Noun', 'Verb', 'Adjective']]

# --- 1. 모델과 필요 도구를 미리 불러오기 ---
print("🚀 모델과 도구들을 불러오는 중입니다...")
try:
    # 저장된 모델 파일들의 경로를 정확하게 확인해주세요.
    model = joblib.load('./Project1/models/XGBoost/korean_topic_model.pkl')
    vectorizer = joblib.load('./Project1/models/XGBoost/tfidf_vectorizer.pkl')
    label_encoder = joblib.load('./Project1/models/XGBoost/label_encoder.pkl')
    print("✅ 모델과 도구 로딩 완료.")
except FileNotFoundError:
    print("❌ 오류: 저장된 모델 파일(.pkl)을 찾을 수 없습니다.")
    print("먼저 XGBoost.py 파일을 실행하여 모델을 학습하고 저장해주세요.")
    exit()

# --- 3. 예측을 수행할 API 엔드포인트 정의 ---
@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    user_input = data.get('sentence') # .get()을 사용하면 'sentence' 키가 없을 때 오류 대신 None을 반환합니다.
    
    if not user_input or not user_input.strip():
        return jsonify({'error': 'sentence 키가 없거나 문장이 비어있습니다.'}), 400

    # 문장 끝부분 가중치 적용 로직 (선택적으로 유지 또는 제거)
    sentences = [s.strip() for s in user_input.replace(',', '.').split('.') if s.strip()]
    processed_input = user_input
    if len(sentences) > 1:
        last_sentence = sentences[-1]
        processed_input = user_input + " " + (last_sentence + " ") * 2
    
    # --- ✨ 예측 및 반환 형식 변경 부분 ---
    # 1. 입력된 텍스트를 TF-IDF 벡터로 변환
    input_vec = vectorizer.transform([processed_input])

    # 2. 각 주제별 '확률'을 예측합니다. (결과는 numpy 배열)
    probabilities = model.predict_proba(input_vec)[0]

    # 3. 주제 이름 리스트와 확률 리스트를 짝지어 딕셔너리를 만듭니다.
    #    (예: {'영화/미디어': 0.4, '스포츠': 0.25, ...})
    #    점수를 퍼센트처럼 보이게 하기 위해 100을 곱하고 소수점 2자리까지 반올림합니다.
    scores_dict = {
        topic: round(prob * 100, 2) 
        for topic, prob in zip(label_encoder.classes_, probabilities)
    }

    # 4. 최종 결과를 요구사항에 맞는 JSON 구조로 만들어 반환합니다.
    return jsonify({'scores': scores_dict})
    # --- ✨ 변경 끝 ---

# --- 4. API 서버 실행 ---
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=False) # 실제 운영 시에는 debug=False로 변경하는 것이 좋습니다.