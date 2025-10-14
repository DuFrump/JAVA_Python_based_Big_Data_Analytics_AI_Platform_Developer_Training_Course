import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder # 레이블 인코더 임포트
from xgboost import XGBClassifier
from sklearn.metrics import accuracy_score, f1_score
import numpy as np
import os 
from collections import Counter # 데이터 확인용 임포트
from konlpy.tag import Okt # Okt 형태소 분석기 임포트
from matplotlib import font_manager, rc
import matplotlib.pyplot as plt

font_path = 'C:/Windows/Fonts/malgun.ttf'
font_name = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font_name)
plt.rcParams['axes.unicode_minus'] = False

# -------------------------------------------------------------------
# 1. 데이터 로드 및 통합 (5개 파일)
# -------------------------------------------------------------------
print("---------- 데이터 로드 및 통합 시작 ----------")

topics = ['기술/IT', '스포츠', '영화/미디어', '경제/제테크', '일상/여행', 'NaN']
file_map = {
    '기술/IT': '기술_IT.txt', 
    '스포츠': '스포츠.txt', 
    '영화/미디어': '영화_미디어.txt', 
    '경제/제테크': '경제_제테크.txt', 
    '일상/여행': '일상_여행.txt',
    'NaN' : 'NaN.txt'
}

# 실제 파일 경로는 개발자님의 환경에 맞게 설정해주세요!
base_dir = './Project1/dataSet/created_dataset' 

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
        print(f"경고: 파일 {file_name}을(를) 찾을 수 없습니다. 경로를 확인하세요.")
        continue

print(f"총 학습 문장 개수: {len(X_train_text)}개")
print(f"라벨 분포: {Counter(y_train)}")
print("------------------------------------------")


# -------------------------------------------------------------------
# 2. 데이터 분할 (훈련/검증용)
# -------------------------------------------------------------------
X_train, X_val, y_train_labels, y_val_labels = train_test_split(
    X_train_text, y_train, test_size=0.2, random_state=42, stratify=y_train
)

# -------------------------------------------------------------------
# 3. 텍스트 벡터화 (TF-IDF) 및 라벨 인코딩 (Okt 적용)
# -------------------------------------------------------------------
print("Okt 형태소 분석기로 명사 추출을 시작합니다...")

# Okt 형태소 분석기 객체 생성
okt = Okt()

# 명사만 추출하는 토크나이저 함수 정의
def tokenize(text):
    return okt.nouns(text)

my_stopwords = [
    '요즘', '관심', '마음', '이번', '것', '게', '난', '내', '많은',
    '생각', '느낌', '궁금', '이유', '하나', '정도', '사실', '문제', '질문', '정말', '진짜',
    '저', '나', '우리', '그', '이', '거', '수', '곳', '때', '뭐',
    '오늘', '어제', '내일', '지금', '때문', '이후', '처음', '시작',
    '하기', '보기', '사용', '이용', '관련', '위해', '대한', '대해', '통해'
]

# TfidfVectorizer가 Okt 토크나이저를 사용하도록 설정
vectorizer = TfidfVectorizer(tokenizer=tokenize, max_df=0.9, min_df=2, stop_words=my_stopwords)
X_train_vec = vectorizer.fit_transform(X_train)
X_val_vec = vectorizer.transform(X_val)

# 라벨 인코딩: 문자열 라벨을 모델이 이해할 수 있는 숫자로 변환
label_encoder = LabelEncoder()
y_train_encoded = label_encoder.fit_transform(y_train_labels)
y_val_encoded = label_encoder.transform(y_val_labels) 

print(f"학습 데이터셋 크기 (Features): {X_train_vec.shape}")
print("------------------------------------------")


from imblearn.over_sampling import SMOTE

# 1. SMOTE 객체 생성
# random_state를 고정해야 매번 실행해도 같은 결과를 얻을 수 있어요.
smote = SMOTE(random_state=42)

# 2. 훈련 데이터에 SMOTE 적용 (벡터화 이후, 모델 학습 이전)
# X_train_vec와 y_train_encoded를 넣어서 양을 늘려줍니다.
print("\nSMOTE 오버샘플링 적용 시작...")
X_train_resampled, y_train_resampled = smote.fit_resample(X_train_vec, y_train_encoded)

print(f"SMOTE 적용 전 학습 데이터: {X_train_vec.shape}, 라벨: {y_train_encoded.shape}")
print(f"SMOTE 적용 후 학습 데이터: {X_train_resampled.shape}, 라벨: {y_train_resampled.shape}")
print(f"오버샘플링 후 라벨 분포: {Counter(y_train_resampled)}")
print("------------------------------------------")


# -------------------------------------------------------------------
# 4. XGBoost 분류 모델 학습 (최종)
# -------------------------------------------------------------------
xgb_classifier = XGBClassifier(
    n_estimators=300,
    max_depth=6,
    learning_rate=0.1,
    n_jobs=-1,
    random_state=42,
    eval_metric='mlogloss',
    use_label_encoder=False
)

print("XGBoost 분류 모델 학습 시작...")
xgb_classifier.fit(X_train_resampled, y_train_resampled)

# 5. 모델 성능 검증
y_pred_encoded = xgb_classifier.predict(X_val_vec)
accuracy = accuracy_score(y_val_encoded, y_pred_encoded)
macro_f1 = f1_score(y_val_encoded, y_pred_encoded, average='macro')

print("\n------------------- 학습 및 검증 결과 -------------------")
print(f"최종 정확도 (Accuracy): {accuracy:.4f}")
print(f"Macro F1-Score: {macro_f1:.4f} (클래스별 균형 성능)")
print("---------------------------------------------------------")
    
# 참고: 예측된 숫자를 다시 문자열 라벨로 복원하는 방법
predicted_labels = label_encoder.inverse_transform(y_pred_encoded[:5])
print("상위 5개 예측 라벨 (복원):", predicted_labels) 
print("---------------------------------------------------------")

# -------------------------------------------------------------------
# 6. 새로운 문장으로 예측 수행하기
# -------------------------------------------------------------------
samples = [
    '아, 요즘 엔비디아랑 AMD 주식에 관심이 있어.',
    '요즘 바르셀로나가 너무 못해서 마음이 아파..',
    '이번에 개봉된 영화 봤어? 재밌더라.',
    '물리학의 전반적인 역사에 대해 알고 싶어. 그게 관심이 가는 주제야.',
    '삼엽충 화석의 고생물학적 연구가 최근 고려대학교에서 발표되었대.',
    '미술관에서 조선시대 도자기 감상하는 게 취미인 사람이 많을까?',
    '혹시 말이야, 엔비디아의 새로운 GPU 드라이버 업데이트했어?',
    '난 요즘 유럽 축구 투어에 관심이 있어.',
    '난 요즘 분위기 좋은 카페 탐방과 여행에 관심이 있어.',
    '난 요즘 인공지능 프로그래밍에 관심이 있어.',
    '난 요즘 영화 보는 것에 푹 빠져있어.',
    '요즘 20대의 투자 방식에 대해 많은 것을 공부하려고 하고 있어.',
    '아침에 조깅하고 왔어. 달리기를 했는데 너무 재밌더라!',
    '요즘 미국 기술주 중심의 ETF에 적립식으로 투자하고 있어.',
    '이번 주말 K리그 경기는 정말 역대급으로 치열했어.',
    '나는 영화를 볼 때 감독의 전작들을 모두 찾아보는 습관이 있어.',
    '새로 출시된 그래픽카드 성능이 이전 세대보다 얼마나 향상되었는지 궁금하다.',
    '퇴근 후에 친구랑 동네 맛집에서 저녁 먹기로 약속했어.',
    '르네상스 시대 미술이 현대 디자인에 미친 영향에 대해 토론해 보고 싶어.',
    '그 선수가 구단과 연봉 협상에서 갈등을 빚고 있다는 기사를 봤어.',
    '요즘 OTT 구독료가 너무 올라서 어떤 서비스를 해지할지 고민 중이야.',
    '다음 달에 떠날 해외여행을 위해 환율을 매일 체크하고 있다.',
    '프로그래밍 언어의 역사와 발전 과정에 대한 다큐멘터리를 재밌게 봤어.',
    '헬스장에서 유산소 운동보다 근력 운동에 더 집중하려고 해.',
    '셰익스피어의 4대 비극이 인간의 보편적 감정을 어떻게 다루는지 분석해 볼까?',
    '난 이 스포츠 팀의 유니폼을 디자인한 디자이너의 팬이야.',
    '저 배우가 출연한 작품은 믿고 보는 편이라, 이번 신작도 바로 시청했지.',
    '최근 발표된 소비자물가지수가 예상보다 높아서 시장이 긴장하고 있대.',
    '주말에 아무 계획 없이 그냥 집에서 반려묘랑 뒹굴거리는 게 최고야.',
    '인공지능 윤리 문제는 기술 개발 속도를 따라가지 못하고 있는 것 같아.',
    'E-스포츠 구단의 운영 방식이 전통적인 스포츠 구단과 어떻게 다른지 알아보고 있어.',
    '분위기 좋은 카페에서 책 읽는 것만큼 좋은 재충전 방법도 없는 것 같아.',
    '고대 로마의 수도 시설이 당시 공중보건에 기여한 바가 크다고 생각해.'
]

samples_vec = vectorizer.transform(samples)
predicted_encoded = xgb_classifier.predict(samples_vec)
predicted_labels = label_encoder.inverse_transform(predicted_encoded)

print("\n----------- 새로운 문장 예측 결과 -----------")
for text, label in zip(samples, predicted_labels):
    print(f"'{text}'  ->  예측: **{label}**")
print("-------------------------------------------")

# # 단어 사전
# print('단어 사전')
# print(vectorizer.vocabulary_)