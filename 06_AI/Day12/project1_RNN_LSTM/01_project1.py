# -------------------------------------------------------------------
# 0. 필요한 라이브러리 임포트
# -------------------------------------------------------------------
import os
import pandas as pd
import numpy as np
from collections import Counter
from matplotlib import font_manager, rc
import matplotlib.pyplot as plt
import joblib

# ----- [변경] 머신러닝 -> 딥러닝 라이브러리 -----
# from sklearn.feature_extraction.text import TfidfVectorizer (X)
# from xgboost import XGBClassifier (X)
# from imblearn.over_sampling import SMOTE (X)
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder
from sklearn.metrics import accuracy_score, f1_score
from sklearn.utils import class_weight # (SMOTE 대신 사용할 클래스 가중치)

import tensorflow as tf
from tensorflow import keras
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Embedding, GRU, Dense, Dropout, LSTM # (우리가 배운 RNN/LSTM/GRU!)
from tensorflow.keras.preprocessing.text import Tokenizer # (TF-IDF를 대체할 '토크나이저')
from tensorflow.keras.preprocessing.sequence import pad_sequences # (문장 길이를 맞출 '패딩')
from tensorflow.keras.callbacks import ModelCheckpoint, EarlyStopping # (우리가 배운 '콜백')

import sys
sys.path.append('./Project1/models/XGBoost') # (사용자님 경로 유지)

# --- 폰트 설정 (사용자님 코드 유지) ---
font_path = 'C:/Windows/Fonts/malgun.ttf'
font_name = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font_name)
plt.rcParams['axes.unicode_minus'] = False

# -------------------------------------------------------------------
# 1. 데이터 로드 및 통합 (사용자님 코드 유지)
# -------------------------------------------------------------------
print("---------- 1. 데이터 로드 및 통합 시작 ----------")
# (이 부분은 사용자님 코드와 100% 동일합니다)
topics = ['기술/IT', '스포츠', '영화/미디어', '경제/제테크', '일상/여행', '기타_주제']
file_map = {
    '기술/IT': '기술_IT.txt', 
    '스포츠': '스포츠.txt', 
    '영화/미디어': '영화_미디어.txt', 
    '경제/제테크': '경제_제테크.txt', 
    '일상/여행': '일상_여행.txt',
    '기타_주제' : '기타_주제.txt'
}
base_dir = './Day12/project1_RNN_LSTM/dataSet/created_dataset' 
X_train_text = []
y_train = []
for topic, file_name in file_map.items():
    file_path = os.path.join(base_dir, file_name)
    try:
        with open(file_path, 'r', encoding='utf-8') as f:
            lines = [line.strip() for line in f if line.strip()]
            X_train_text.extend(lines)
            y_train.extend([topic] * len(lines))
    except FileNotFoundError:
        print(f"경고: 파일 {file_name}을(를) 찾을 수 없습니다.")
        continue
print(f"총 학습 문장 개수: {len(X_train_text)}개")
print(f"라벨 분포: {Counter(y_train)}")
print("------------------------------------------")


# -------------------------------------------------------------------
# 2. 데이터 분할 (사용자님 코드 유지)
# -------------------------------------------------------------------
print("\n---------- 2. 훈련/검증 데이터 분할 ----------")
X_train, X_val, y_train_labels, y_val_labels = train_test_split(
    X_train_text, y_train, test_size=0.2, random_state=42, stratify=y_train
)
print(f"훈련 데이터: {len(X_train)}개, 검증 데이터: {len(X_val)}개")
print("------------------------------------------")


# -------------------------------------------------------------------
# 3. [변경] 텍스트 전처리 (TF-IDF -> Keras Tokenizer + Padding)
# -------------------------------------------------------------------
print("\n---------- 3. Keras 텍스트 전처리 시작 ----------")

# 멘토 코멘트:
# 딥러닝(RNN/LSTM)은 '단어의 순서'가 생명입니다!
# TF-IDF는 순서를 무시하므로, Keras의 'Tokenizer'로 '단어 사전'을 만들고,
# 'pad_sequences'로 모든 문장의 '길이'를 똑같이 맞춰줍니다.

# (1) 불용어 로드는 사용자님 코드 유지 (Tokenizer에 직접 적용은 안 되지만, 전처리 단계에서 뺄 수 있습니다)
# (간소화를 위해 이 예제에서는 불용어 처리를 Tokenizer의 기본 필터에 맡깁니다.)

# (2) Keras Tokenizer 설정
VOCAB_SIZE = 20000  # 딥러닝 모델이 기억할 최대 단어 수 (하이퍼파라미터)
MAX_LEN = 100       # 문장의 최대 길이 (하이퍼파라미터)

tokenizer = Tokenizer(num_words=VOCAB_SIZE, oov_token='<UNK>') # <UNK> = 사전에 없는 단어 처리
tokenizer.fit_on_texts(X_train) # 훈련 데이터(X_train)로 '단어 사전' 생성

# (3) 문장 -> 숫자 시퀀스(순서)로 변환
X_train_seq = tokenizer.texts_to_sequences(X_train)
X_val_seq = tokenizer.texts_to_sequences(X_val)
print("전처리 전 샘플 (문장):", X_train[0])
print("전처리 후 샘플 (숫자 시퀀스):", X_train_seq[0])

# (4) 패딩(Padding) - 모든 문장의 길이를 MAX_LEN으로 통일
X_train_pad = pad_sequences(X_train_seq, maxlen=MAX_LEN, padding='post', truncating='post')
X_val_pad = pad_sequences(X_val_seq, maxlen=MAX_LEN, padding='post', truncating='post')
print(f"패딩 적용 후 훈련 데이터 shape: {X_train_pad.shape}")
print(f"패딩 적용 후 검증 데이터 shape: {X_val_pad.shape}")
print("패딩 적용 후 샘플 (앞/뒤가 0으로 채워짐):", X_train_pad[0])
print("------------------------------------------")


# -------------------------------------------------------------------
# 4. [변경] 라벨 처리 및 클래스 가중치 (SMOTE -> class_weight)
# -------------------------------------------------------------------
print("\n---------- 4. 라벨 인코딩 및 가중치 계산 ----------")

# (1) 라벨 인코딩 (사용자님 코드 유지)
label_encoder = LabelEncoder()
y_train_encoded = label_encoder.fit_transform(y_train_labels)
y_val_encoded = label_encoder.transform(y_val_labels)
print("라벨 인코딩 샘플:", y_train_encoded[:5])

# (2) 클래스 가중치 계산 (SMOTE 대체)
# 멘토 코멘트:
# 딥러닝에서는 SMOTE보다 'class_weight'를 더 선호합니다.
# 데이터가 적은 클래스(예: '기타_주제')를 틀렸을 때 '더 큰 페널티'를 줘서
# 모델이 불균형을 해소하도록 유도합니다. (SMOTE와 유사한 효과)
class_weights_list = class_weight.compute_class_weight(
    'balanced',
    classes=np.unique(y_train_encoded),
    y=y_train_encoded
)
# Keras가 좋아하는 딕셔너리 형태로 변환
class_weight_dict = dict(enumerate(class_weights_list))
print(f"계산된 클래스 가중치 (적은 클래스가 높은 값): {class_weight_dict}")
print("------------------------------------------")


# -------------------------------------------------------------------
# 5. [변경] 딥러닝 모델(GRU) 구축 (XGBoost -> Keras)
# -------------------------------------------------------------------
print("\n---------- 5. 딥러닝 모델(GRU) 구축 ----------")
# 멘토 코멘트:
# 여기가 바로 '엔진'을 교체하는 부분입니다!
# 1. Embedding: '숫자'를 '의미 벡터'로 변환 (단어의 '의미'를 학습)
# 2. GRU: '순서(문맥)'를 파악 (LSTM보다 빠르고 단순)
# 3. Dense: '최종 결정' (우리가 배운 DNN)

model = Sequential()
# (1) 임베딩 층
model.add(Embedding(input_dim=VOCAB_SIZE, output_dim=128, input_length=MAX_LEN))

# (2) RNN 층 (GRU 사용, LSTM(128)으로 바꿔도 됩니다)
model.add(GRU(128, return_sequences=False)) # return_sequences=False가 기본입니다.

# (3) 과적합 방지 (우리가 배운 Dropout)
model.add(Dropout(0.4))

# (4) 분류를 위한 Dense 층 (우리가 배운 DNN)
# (선택 사항: GRU -> Dense(100) -> Dropout -> Dense(6) 처럼 은닉층을 더 쌓아도 됩니다)
# model.add(Dense(100, activation='relu'))
# model.add(Dropout(0.4))

# (5) 출력층 (우리가 배운 Softmax)
num_classes = len(label_encoder.classes_)
model.add(Dense(num_classes, activation='softmax'))

model.summary() # 모델 구조 확인

# (6) 모델 컴파일 (우리가 배운 것들!)
model.compile(
    optimizer='adam',                        # 옵티마이저: Adam
    loss='sparse_categorical_crossentropy',  # 라벨이 [0,1,2..] 정수이므로 'sparse'
    metrics=['accuracy']                     # 평가 지표: 정확도
)
print("------------------------------------------")


# -------------------------------------------------------------------
# 6. [변경] 딥러닝 모델 학습 (콜백 사용!)
# -------------------------------------------------------------------
print("\n---------- 6. 딥러닝 모델 학습 시작 ----------")

# (1) 콜백 설정 (우리가 배운 ModelCheckpoint + '조기 종료')
# 'val_loss' (모의고사 손실)을 기준으로 가장 좋은 모델을 저장
checkpoint_cb = ModelCheckpoint(
    './Project1/models/LSTM/best_lstm_model.keras', # (경로 수정 필요)
    save_best_only=True,
    monitor='val_loss',
    verbose=1
)
# 'val_loss'가 5번 연속으로 나아지지 않으면 훈련을 '조기 종료' (시간 절약!)
early_stop_cb = EarlyStopping(
    patience=5,
    monitor='val_loss',
    restore_best_weights=True, # 가장 좋았던 시점의 가중치로 복원
    verbose=1
)

# (2) 모델 훈련
EPOCHS = 20 # (EarlyStopping이 알아서 멈춰줄 겁니다)
BATCH_SIZE = 64 # (딥러닝의 배치 사이즈)

history = model.fit(
    X_train_pad,
    y_train_encoded,
    epochs=EPOCHS,
    batch_size=BATCH_SIZE,
    validation_data=(X_val_pad, y_val_encoded), # '모의고사' 세트
    callbacks=[checkpoint_cb, early_stop_cb],   # '자동 비서'들
    class_weight=class_weight_dict              # '클래스 가중치' 적용
)
print("------------------------------------------")


# -------------------------------------------------------------------
# 7. [변경] 모델 성능 검증 (학습 곡선)
# -------------------------------------------------------------------
print("\n---------- 7. 딥러닝 모델 성능 검증 ----------")

# (1) 최종 검증 (EarlyStopping이 복원한 '최고' 모델로 평가)
val_loss, val_accuracy = model.evaluate(X_val_pad, y_val_encoded)
print(f"\n최종 검증 정확도 (Accuracy): {val_accuracy:.4f}")
print(f"최종 검증 손실 (Loss): {val_loss:.4f}")

# (2) 학습 곡선 그리기 (과적합 확인)
plt.plot(history.history['loss'], label='train_loss')
plt.plot(history.history['val_loss'], label='val_loss')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.title('훈련/검증 손실 곡선')
plt.show()

plt.plot(history.history['accuracy'], label='train_accuracy')
plt.plot(history.history['val_accuracy'], label='val_accuracy')
plt.xlabel('epoch')
plt.ylabel('accuracy')
plt.legend()
plt.title('훈련/검증 정확도 곡선')
plt.show()
print("------------------------------------------")


# -------------------------------------------------------------------
# 8. [변경] 새로운 문장 예측 (XGBoost -> Keras)
# -------------------------------------------------------------------
print("\n---------- 8. 새로운 문장 예측 ----------")

# 멘토 코멘트:
# XGBoost는 vectorizer.transform()를 썼지만,
# 딥러닝은 [Tokenizer -> Padding]의 2단계를 똑같이 거쳐야 합니다!

# (1) 샘플 문장 (사용자님 코드 유지)
samples = [
    '아, 요즘 엔비디아랑 AMD 주식에 관심이 있어.', '요즘 스페인 축구 구단 FC 바르셀로나가 너무 못해서 마음이 아파..', '이번에 개봉된 영화 봤어? 재밌더라.',
    '물리학의 전반적인 역사에 대해 알고 싶어. 그게 관심이 가는 주제야.', '삼엽충 화석의 고생물학적 연구가 최근 고려대학교에서 발표되었대.', '미술관에서 조선시대 도자기 감상하는 게 취미인 사람이 많을까?',
    '혹시 말이야, 엔비디아의 새로운 GPU 드라이버 업데이트했어?', '난 요즘 유럽 축구 투어에 관심이 있어.', '난 요즘 분위기 좋은 카페 탐방과 여행에 관심이 있어.',
    '난 요즘 인공지능 프로그래밍에 관심이 있어.', '난 요즘 영화 보는 것에 푹 빠져있어.', '요즘 20대의 투자 방식에 대해 많은 것을 공부하려고 하고 있어.',
    '아침에 조깅하고 왔어. 달리기를 했는데 너무 재밌더라!', '요즘 미국 기술주 중심의 ETF에 적립식으로 투자하고 있어.', '이번 주말 K리그 경기는 정말 역대급으로 치열했어.',
    '나는 영화를 볼 때 감독의 전작들을 모두 찾아보는 습관이 있어.', '새로 출시된 그래픽카드 성능이 이전 세대보다 얼마나 향상되었는지 궁금하다.', '퇴근 후에 친구랑 동네 맛집에서 저녁 먹기로 약속했어.',
    '르네상스 시대 미술이 현대 디자인에 미친 영향에 대해 토론해 보고 싶어.', '그 선수가 구단과 연봉 협상에서 갈등을 빚고 있다는 기사를 봤어.', '요즘 OTT 구독료가 너무 올라서 어떤 서비스를 해지할지 고민 중이야.',
    '다음 달에 떠날 해외여행을 위해 환율을 매일 체크하고 있다.', '프로그래밍 언어의 역사와 발전 과정에 대한 다큐멘터리를 재밌게 봤어.', '헬스장에서 유산소 운동보다 근력 운동에 더 집중하려고 해.',
    '셰익스피어의 4대 비극이 인간의 보편적 감정을 어떻게 다루는지 분석해 볼까?', '난 이 스포츠 팀의 유니폼을 디자인한 디자이너의 팬이야.', '저 배우가 출연한 작품은 믿고 보는 편이라, 이번 신작도 바로 시청했지.',
    '최근 발표된 소비자물가지수가 예상보다 높아서 시장이 긴장하고 있대.', '주말에 아무 계획 없이 그냥 집에서 반려묘랑 뒹굴거리는 게 최고야.', '인공지능 윤리 문제는 기술 개발 속도를 따라가지 못하고 있는 것 같아.',
    'E-스포츠 구단의 운영 방식이 전통적인 스포츠 구단과 어떻게 다른지 알아보고 있어.', '분위기 좋은 카페에서 책 읽는 것만큼 좋은 재충전 방법도 없는 것 같아.', '고대 로마의 수도 시설이 당시 공중보건에 기여한 바가 크다고 생각해.',
    '인공지능이 좋아', '엔비디아 GPU 드라이버 업데이트', '인공지능 프로그래밍!'
]

new_samples = [
    "E-스포츠 팀의 데이터 분석가가 되려고 파이썬 코딩을 배우고 있어.", "최근 개봉한 영화의 흥행 실패로 관련 미디어 기업의 주가가 하락했어.",
    "영화 '반지의 제왕' 촬영지인 뉴질랜드로 배낭여행을 떠나려고 항공권을 알아봤다.", "인기 축구 선수가 광고하는 최신 스마트폰의 카메라 성능이 그렇게 좋대.",
    "다음 투자처로 엔터테인먼트 산업의 성장 가능성을 분석하는 리포트를 읽었다.", "이번 주말에 다 같이 유니폼 입고 경기장 가서 목청껏 소리 지르자.",
    "요즘 같은 시기에는 원금 보장되는 상품에 돈을 묶어두는 게 제일 안전해.", "그 배우의 차기작이 정말 기대돼. 이번엔 어떤 캐릭터를 연기할지 궁금하다.",
    "퇴근하고 동네 공원에서 잠깐 바람 sue는 게 요즘 내 유일한 행복이야.", "머신러닝 모델의 과적합 문제를 해결하기 위한 수학적 원리가 궁금하다.",
    "조선시대 후기 민화에 나타난 해학적 표현 양식에 대해 토론해보자.", "애덤 스미스의 '국부론'이 현대 자본주의에 미친 영향은 무엇일까?",
    "고대 그리스 철학자들이 생각한 '행복'의 정의에 대해 논하시오."
]

# (2) 예측 함수화 (편의를 위해)
def predict_new_sentences(texts):
    # 1. 문장 -> 숫자 시퀀스
    seqs = tokenizer.texts_to_sequences(texts)
    # 2. 패딩
    pads = pad_sequences(seqs, maxlen=MAX_LEN, padding='post', truncating='post')
    # 3. 예측 (확률값)
    predictions = model.predict(pads)
    # 4. 가장 높은 확률의 '인덱스'
    predicted_indices = np.argmax(predictions, axis=1)
    # 5. 인덱스 -> 원래 라벨(글자)
    predicted_labels = label_encoder.inverse_transform(predicted_indices)
    return predicted_labels

# (3) 예측 실행
print("\n----------- LSTM(GRU) 문장 예측 결과 -----------")
predicted_labels = predict_new_sentences(samples)
for text, label in zip(samples, predicted_labels):
    print(f"'{text}'  ->  예측: **{label}**")
print("-------------------------------------------")

print("\n----------- LSTM(GRU) 새로운 문장 예측 결과 -----------")
new_predicted_labels = predict_new_sentences(new_samples)
for text, label in zip(new_samples, new_predicted_labels):
    print(f"'{text}'  ->  예측: **{label}**")
print("-------------------------------------------")


# -------------------------------------------------------------------
# 9. [변경] 학습된 딥러닝 모델 및 도구 저장
# -------------------------------------------------------------------
print("\n학습된 모델과 도구들을 저장합니다...")

# (1) 딥러닝 모델 저장 (best_lstm_model.keras는 이미 콜백이 저장 중)
# model.save('./Project1/models/LSTM/korean_topic_model_final.keras')

# (2) [중요!] Tokenizer와 LabelEncoder 저장
# 멘토 코멘트:
# 나중에 예측하려면 '단어 사전(Tokenizer)'과 '라벨 사전(LabelEncoder)'이
# '훈련 때와 100% 동일'해야 합니다!
joblib.dump(tokenizer, './06_AI/Day12/project1_RNN_LSTM/models/keras_tokenizer.pkl')
joblib.dump(label_encoder, './06_AI/Day12/project1_RNN_LSTM/models/label_encoder.pkl') # (이건 XGBoost와 동일)
print("딥러닝 모델(Best)과 도구들이 성공적으로 저장되었습니다.")