from sklearn.datasets import fetch_20newsgroups
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import accuracy_score, f1_score, classification_report
from scipy.sparse import hstack

print('---------- 임포트 완료 ---------- ')
print()


remove_parts = ('headers', 'footers', 'quotes')
train = fetch_20newsgroups(subset='train', remove=remove_parts)
test = fetch_20newsgroups(subset='test', remove=remove_parts)

print('---------- 데이터 로드 완료 ---------- ')
print()


X_train_text = train.data
y_train = train.target
X_test_text = test.data
y_test = test.target
target_names = train.target_names

print('---------- 트레인/테스트 분할 완료 ---------- ')
print()

print()
print('데이터 개수 / 클래스 개수')
print(f'Train: {len(X_train_text)} // Test: {len(X_test_text)} // Classes: {len(target_names)}')
print()