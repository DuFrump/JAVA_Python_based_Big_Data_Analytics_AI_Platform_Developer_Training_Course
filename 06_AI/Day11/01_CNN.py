'''
CNN - Convolutional Neural Network
합성곱(Convolution) - 입력 이미지에 필터를 적용해서 특징(경계, 패턴 등)들을 추출하는 연산.
특성맵(Feature Map) - 필터가 입력을 통과한 결과로, 해당 필터가 감지한 특징의 강도를 나타내는 출력.

패팅(Padding) - 합성곱 연산 시 이미지 가장자리 정보 손실을 예방
스트라이드(Stride) - 필터가 한 번에 이동하는 칸 수로, 값이 클수록 출력 크기가 작아짐.
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

import matplotlib as plt

plt.plot(history.history['loss'], label='train')
plt.plot(history.history['val_loss'], label='val')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.show()

print('\n----- 모델 evaluate -----')
print(model.evaluate(val_scaled, val_target))