# IMDB 영화 리뷰 데이터셋 (단어가 이미 정수로 바꿔져 있는 상태)
from keras.datasets import imdb

# 자주 사용하는 단어 200개만 사용
# keras IMDB 단어사전이 이미 만들어져 있음
# 그 단어 사전에 단어가 많음 / 200개만 취급을 하겠다
(train_input, train_target), (test_input, test_target) = imdb.load_data(num_words=200)

print('\n훈련/테스트 데이터 크기')
print(train_input.shape, test_input.shape) # (25000,) (25000,)
# 각각의 리뷰 샘플이 python 리스트 '객체'로 이루어진 넘피 배열이다

print('\n첫 번째 리뷰(객체) 길이 확인')
print(len(train_input[0])) # 218 (단어가 218개)

print('\n두 번째 리뷰(객체) 길이 확인')
print(len(train_input[1])) # 189 (단어가 189개)

print('\n첫 번째 리뷰 확인')
print(train_input[0]) # 어휘 사전(200개)에 없는 단어는 모두 2로 표시

print('\n타겟 데이터 20개 확인')
print(train_target[:20]) # 1 긍정 0 부정

# 훈련/검증 데이터 20프로 분리
from sklearn.model_selection import train_test_split

train_input, val_input, train_target, val_target = train_test_split(train_input, train_target, test_size=0.2, random_state=42)

# 훈련 세트 몇 가지 조사!
# 모든 리뷰의 길이를 조사해보기
import numpy as np

# 샘플별로 길이 반환
lengths = np.array([len(x) for x in train_input])

print('\n샘플 길이의 평균/중앙값')
print(np.mean(lengths), np.median(lengths)) # 238.71364 178.0
# 한 쪽으로 치우쳐져있는 것을 확인 할 수 있다

# 그래프로 확인해보기 >>>> 100 단어로 맞추면 적정
import matplotlib.pyplot as plt

plt.hist(lengths)
plt.xlabel('length')
plt.ylabel('frequency')
plt.show()

# 케라스에서 시퀸스 데이터 전처리 기능 제공
from keras.preprocessing.sequence import pad_sequences

# 100단어로, 길면 자르고 부족하면 0으로 패딩(안 정해주면 최대 길이로 패딩)
train_seq = pad_sequences(train_input, maxlen=100)

print('\ntrain_seq.shape')
print(train_seq.shape) # (25000, 100)

print('\ntrain_seq의 첫 번째 샘플')
print(train_seq[0])

print('\ntrain_input 첫 번째 샘플의 마지막 부분')
print(train_seq[0][-10:]) 
# 이를 통해 앞 부분을 잘라내고 뒷 부분을 살린 것을 파악 가능

print('\ntrain_seq의 다섯 번째 샘플')
print(train_seq[4])

# 검증 세트도 전처리하기
val_seq = pad_sequences(val_input, maxlen=100)

# -------- 순환 신경망 만들기 --------
import keras

model = keras.Sequential()
model.add(keras.layers.Input(shape=(100,200))) # 한 샘플에 100단어 / 한 단어에 200 one-hot encoding(단어사전 200개로 지정했기 때문)
model.add(keras.layers.SimpleRNN(8)) # 순환 신경망 셀 8개
model.add(keras.layers.Dense(1, activation='sigmoid'))

train_oh = keras.utils.to_categorical(train_seq)

print('\n원핫 인코딩 이후 훈련 세트 크기')
print(train_oh.shape) # (20000, 100, 200)

print('\n첫 번째 샘플, 첫 번째 단어 확인')
print(train_oh[0][0][:12]) # [0. 0. 0. 0. 0. 0. 0. 0. 0. 0. 1. 0.]

print('\n원핫 인코딩 이후 ')
print(np.sum(train_oh[0][0])) # 1

# 검증 세트도 원핫 인코딩
val_oh = keras.utils.to_categorical(val_seq)

# 모델 서머리
# 1672 = 200x8(웨이트) + 8x8(순환가중치) + 8(바이어스)
# 9 = 8(웨이트) + 1(바이어스)
print()
model.summary()

# 모델 컴파일
model.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

checkpoint_cb = keras.callbacks.ModelCheckpoint('./Day12/models/best-simplernn_model.keras', save_best_only=True)
early_stopping_cb = keras.callbacks.EarlyStopping(patience=5, restore_best_weights=True)
lr_scheduler_cb = keras.callbacks.ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=3)

history = model.fit(train_oh, train_target, epochs=100, batch_size=64, validation_data=(val_oh, val_target), callbacks=[checkpoint_cb, early_stopping_cb, lr_scheduler_cb])

plt.plot(history.history['loss'], label='train')
plt.plot(history.history['val_loss'], label='val')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.show()

print('\n----- 테스트 점수 -----')
print(model.evaluate(val_oh, val_target)) # [0.5434930920600891, 0.730400025844574]


# ---------- 단어 임베딩 사용 ----------
# 원핫 인코딩은 샘플의 크기를 200차원까지 늘렸다. 
# 인베딩은 차원을 절약할 수 있다.
# 덕분에 단어사전은 500으로 늘릴 수가 있게 된다.
# (한 문장 단어 수는 100으로 동일하게 세팅)

(train_input, train_target), (test_input, test_target) = imdb.load_data(num_words=500)

train_input, val_input, train_target, val_target = train_test_split(train_input, train_target, test_size=0.2, random_state=42)

train_seq = pad_sequences(train_input, maxlen=100)
val_seq = pad_sequences(val_input, maxlen=100)

model_emb = keras.Sequential()
model_emb.add(keras.layers.Input(shape=(100,)))
model_emb.add(keras.layers.Embedding(500, 16)) # 단어 사전 크기 500, 단어마다 16차원
# 임베딩 초기화 범위 [-0.05, 0.05]
model_emb.add(keras.layers.SimpleRNN(8))
model_emb.add(keras.layers.Dense(1, activation='sigmoid'))

print()
model_emb.summary()
# 8000 = 500 x 16 (임베딩 파라미터)
# 200 = 16 x 8(웨이트) + 8 x 8(순환 웨이트) + 8(바이어스)

model_emb.compile(optimizer='adam', loss='binary_crossentropy', metrics=['accuracy'])

checkpoint_cb = keras.callbacks.ModelCheckpoint('./Day12/models/best-embedrnn_model.keras', save_best_only=True)
early_stopping_cb = keras.callbacks.EarlyStopping(patience=5, restore_best_weights=True)
lr_scheduler_cb = keras.callbacks.ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=3)

history = model_emb.fit(train_seq, train_target, epochs=100, batch_size=64, validation_data=(val_seq, val_target), callbacks=[checkpoint_cb, early_stopping_cb, lr_scheduler_cb])

plt.plot(history.history['loss'], label='train')
plt.plot(history.history['val_loss'], label='val')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.show()

print('\n----- 테스트 점수 -----')
print(model_emb.evaluate(val_seq, val_target)) # [0.4613429307937622, 0.782800018787384]