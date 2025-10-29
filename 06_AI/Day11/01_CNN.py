'''
CNN(Convolutional Neural Network) - 이미지 인식을 위해 합성곱과 풀링을 사용하는 딥러닝 모델 구조.
채널(Channel) - 이미지의 '깊이'를 나타내며, 흑백은 1, 컬러(RGB)는 3의 값을 가짐.
합성곱(Convolution) - 입력 이미지에 필터(커널)를 적용해서 특징(경계, 패턴 등)들을 추출하는 핵심 연산.
필터(Filter)/커널(Kernel) - 이미지의 특징을 찾기 위해 씌우는 '돋보기'이자, 학습을 통해 업데이트되는 가중치(파라미터).
패딩(Padding) - 합성곱 연산 시 이미지 가장자리 정보 손실을 예방하고 출력 크기를 조절하기 위해 입력 주위를 특정 값(주로 0)으로 채우는 것.
스트라이드(Stride) - 필터가 한 번에 이동하는 칸 수로, 값이 클수록 출력 크기가 작아짐.
활성화 함수(Activation Function) (ReLU) - 합성곱 연산이 끝난 후 비선형성을 추가하여 모델의 표현력을 높이는 함수 (CNN에선 주로 ReLU 사용).
특성맵(Feature Map) - 필터(커널)가 입력을 통과한 결과로, 해당 필터가 감지한 특징의 강도를 나타내는 2D/3D 출력.
풀링(Pooling) - 특성맵의 크기를 줄여(다운샘플링) 연산량을 감소시키고 핵심 특징을 강조하는 연산 (주로 Max Pooling 사용).
플래튼(Flatten) - 특징 추출부(합성곱/풀링)를 통과한 3차원 특성맵을 1차원 벡터로 쫙 펴주어, 완전 연결 층으로 전달하는 다리 역할.
완전 연결 층(Fully Connected Layer)/밀집 층(Dense) - 플래튼을 통해 1차원으로 변환된 특징 벡터를 입력받아, 이미지를 최종 분류(예측)하는 층.
'''

# ===========================================================================================

import keras
import tensorflow as tf

keras.utils.set_random_seed(42)
tf.random.set_seed(42)
tf.config.experimental.enable_op_determinism()

from sklearn.model_selection import train_test_split

print('\n----- 패션 MNIST 데이터 로드 -----')
(train_input, train_target), (test_input, test_target) = keras.datasets.fashion_mnist.load_data()

print('\n----- train_input 크기 확인 -----')
print(train_input.shape) # (60000, 28, 28)

# 케라스 합성곱 층에 넣으려면,,, 기본적으로 3차원(구조) 입력을 기대함.
# 컬러 이미지는 채널이 3개(RGB)이기 때문.
# 컴퓨터 비전 분야에서의 규칙. - 데이터 배열 (이미지 수, 세로, 가로, 채널)
train_scaled = train_input.reshape(-1, 28, 28, 1) / 255.0

print('\n----- 3차원 변환 후 크기 -----')
print(train_scaled.shape) # (60000, 28, 28, 1)

train_scaled, val_scaled, train_target, val_target = train_test_split(train_scaled, train_target, test_size=0.2, random_state=42)

# ---------- 합성곱 신경망 만들기 ----------
model = keras.Sequential()
model.add(keras.layers.Input(shape=(28,28,1))) # 3차원 입력을 기대 // 입력층
model.add(keras.layers.Conv2D(32, kernel_size=3, activation='relu', padding='same')) # 도장 32개, 커널사이즈 3x3 // 은닉층 시작
# >>> 28 x 28 x 32 (특성맵 32장)
model.add(keras.layers.MaxPool2D(2)) # 4개 중 가장 큰 값으로 대체
# >>> 14 x 14 x 32 (특성맵 32장)
model.add(keras.layers.Flatten())
# >>> 6272 x 1 (14 x 14 x 32를 1열로 펼치기)
model.add(keras.layers.Dense(100, activation='relu')) # 뉴런 100개
model.add(keras.layers.Dropout(0.4)) # Dropout method를 이용해서 일반화 성능 향상 // 은닉층 종료
model.add(keras.layers.Dense(10, activation='softmax')) # 클래스 10개 // 출력층
print()

model.summary()

# 3X3X32 + 32 = 320
# 6272 x 100 + 100 = 627300
# 100 x 10 + 10 = 1010

# 결국 어떤 구조와 숫자(파라미터)를 세팅해서 적절한 숫자를 찾아가는 과정.
model.compile(optimizer='adam', loss='sparse_categorical_crossentropy', metrics=['accuracy'])
checkpoint_cb = keras.callbacks.ModelCheckpoint('./Day11/models/best-cnn-model.keras', save_best_only=True)
early_stopping_cb = keras.callbacks.EarlyStopping(patience=2, restore_best_weights=True)

print('\n----- 모델 훈련 -----')
history = model.fit(train_scaled, train_target, epochs=20, validation_data=(val_scaled, val_target), callbacks=[checkpoint_cb, early_stopping_cb])

import matplotlib.pyplot as plt

plt.plot(history.history['loss'], label='train')
plt.plot(history.history['val_loss'], label='val')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.show()

print('\n----- 모델 evaluate -----')
print(model.evaluate(val_scaled, val_target)) # - accuracy: 0.9142 - loss: 0.2457


# (검증) 첫 번째 사진 그림으로 확인
print('\n첫 번째 사진의 차원: ', val_scaled[0].shape) # 28, 28, 1

plt.imshow(val_scaled[0].reshape(28, 28), cmap='gray_r')
plt.show() # 실제 사진 ==> 가방


# 훈련된 모델로 첫 번째 사진 클래스 예측해보기 (결과값: 확률)
print('\n----- 첫 번째 사진 예측 -----')
preds = model.predict(val_scaled[0:1]) # 슬라이싱을 넣어줘야 (1, 28, 28, 1)로 전달이 됨.
print(preds)
'''
[[7.2914687e-17 3.3638042e-25 2.8963967e-18 1.6334074e-17 6.5324464e-15
  6.6230176e-18 3.0252314e-14 8.2424554e-16 1.0000000e+00 6.5238850e-21]]
'''


# 위 확률을 그래프로 확인
plt.bar(range(1,11), preds[0])
plt.xlabel('class')
plt.ylabel('prob')
plt.show()

classes = ['티셔츠', '바지', '스웨터', '드레스', '코트', '센달', '셔츠', '스니커즈', '가방', '앵클부츠']

import numpy as np

print('\n----- 예측 클래스 -----')
print(classes[np.argmax(preds)])

# 테스트 셋으로 테스트 실시
test_scaled = test_input.reshape(-1, 28, 28, 1) / 255.0

print('\n----- 테스트 데이터셋 크기 -----')
print(test_scaled.shape) # (10000, 28, 28, 1)

print('\n----- 테스트 점수 -----')
print(model.evaluate(test_scaled, test_target)) # [0.26379430294036865, 0.9088000059127808]


# 제일 높은 확률의 인덱스를 활용해서 무슨 이이템인지 출력
