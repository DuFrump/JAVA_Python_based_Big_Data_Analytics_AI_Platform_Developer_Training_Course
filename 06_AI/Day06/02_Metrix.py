'''
Accuracy (정확도) : 전체 중 맞춘 비율. 클레스 불균형에 취약.
Precision (정밀도) : 모델이 양성이라 한 것 중 실제 양성 비율. 가짜 양성(FP) 줄이기.
Recall (재현율/민감도) : 실제 양성을 잡아낸 비율. 놓침(FN) 줄이기
F1-score : 정밀도, 재현율의 조화 평균. 둘의 균형을 평가
FPR (위양성률) : 스팸이 아닌데 스팸으로 분류된 비율
ROC, AUC : 임계값 전 구간에 대한 분류력 (민감도 vs 1-특이도)
'''

# 0 0 0 1 0 1 0 1 1 0 0 0 0 1 0 1 0 0 0 0

from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score, precision_score, recall_score, f1_score, roc_auc_score, confusion_matrix, classification_report, RocCurveDisplay
import pandas as pd
import matplotlib.pyplot as plt

# 데이터 로드
data = load_breast_cancer()
X = pd.DataFrame(data.data, columns=data.feature_names)
y = pd.Series(data.target, name='target')

# 악성이 0으로 되어있어서, 0과 1 자리 바꾸기
y = 1 - y

# 데이터 분할
X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, stratify=y, random_state=1
)

# 모델 훈련
dt = DecisionTreeClassifier(random_state=42)
dt.fit(X_train, y_train)

# 예측 및 확률
y_pred = dt.predict(X_test)
print(f'y_pred : {y_pred}\n')
print()
y_proba = dt.predict_proba(X_test)[:,1]
print(f'y_proba: {y_proba}\n')
print()

# 지표 계산
acc = accuracy_score(y_test, y_pred)
pre = precision_score(y_test, y_pred)
rec = recall_score(y_test, y_pred)
f1 = f1_score(y_test, y_pred)
auc = roc_auc_score(y_test, y_proba)

print("--------------- [Metrics] ---------------")
print(f"Accuarcy  : {acc:.4f}")
print(f"Precision : {pre:.4f}")
print(f"Recall    : {rec:.4f}")
print(f"F1-Score  : {f1:.4f}")
print(f"ROC AUC   : {auc:.4f}")
print()

print("Confusion Mextix")
print(confusion_matrix(y_test, y_pred))
print()

print("Classification Report")
print(classification_report(y_test, y_pred))
print()

''' 양성 - 암환자
TP (진짜 양성) : 암환자를 잘 찾아냄
FN (가짜 음성) : 암환자인데 아니라고 분류 (놓침)
FP (가짜 양성) : 암환자 아닌데 맞다고 분류 (오해)
TN (진짜 음성) : 아닌 환자를 아니라고 분류
'''

'''
Confusion Matrix
[71 1] = TP FN
[5 37] = FP TN
=================================================
재현율(Recall)
Recall = TP / (TP + FN)

실제 악성 중에서 모델이 놓치지 않고 잡아낸 비율
값이 높을 수록 암환자를 놓치지 않는다는 의미
FN(놓친 악성)이 줄어들 수록 Recall ↑
=================================================
위양성률 (False Positive Rate, FPR)
FPR = FP / (FP + TN)

"스팸 메일 아닌데 스팸으로 분류한 비율"
값이 높을 수록 일반 메일을 스팸으로 판단하는 빈도 수 ↑
ROC 곡선의 X축이 FPR이다.
=================================================
모델의 임계값(Threshhold)을 조정하면 Recall과 FPR이 trade-off 관계를 가진다
임계값을 낮추면 : Recall ↑ (많이 잡음) but FPR ↑ (오진도 올라감)
임계값을 올리면 : Recall ↓ (놓침 많음) but FPR ↓ (오진도 줄어듬)
=================================================
정밀도 (Precision)
Precision = TP / (TP + FP)

모델이 악성이라고 예측한 것 중에서 실제 악성 비율
FP를 줄여서 판정의 신뢰도 ↑
=================================================
Classification Report
              precision    recall  f1-score   support

           0       0.93      0.94      0.94        72
           1       0.90      0.88      0.89        42

    accuracy                           0.92       114
   macro avg       0.92      0.91      0.91       114
weighted avg       0.92      0.92      0.92       114
=================================================
f1-score - precision과 recall의 조화 평균 (둘 다 높아야 높게 나옴)
하나라도 낮으면 점수가 낮게 나옴. 둘 다 낮아도 낮게 나옴

support - 해당 클래스의 실제 샘플 개수 (데이터 분포 확인용)

accuarcy  - 전체 샘플 중에서 맞춘 비율 (정확도)

macro avg - 클래스별 지표(precision, recall, f1)를 단순 평균
클래스 비율이 불균형일 때 '클래스마다 동일한 중요도'

weighted avg -클래스별 지표를 support(샘플 수)로 가중 평균
데이터 분포를 반영해서 평균을 내므로 accuarcy와 비슷한 경향
'''

# ROC 곡선
# 모든 가능한 임계점들을 넣어보면서 정밀도, 위양성률을 계산하여 그래프 그림
# AUC = ROC 곡선 아래 면석
RocCurveDisplay.from_predictions(y_test, y_proba)
plt.title('ROC Curve (RandomForset)')
plt.show()