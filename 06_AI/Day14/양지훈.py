'''
영화리뷰 IMDB 데이터셋을 사용하여

LSTM 구조의 순환신경망을 학습시키고 테스트를 진행하시오.

적용사항

- 훈련/검증 손실곡선 o
- 콜백 포인트 (모델 저장, 파라미터 복원) o
- 드랍아웃 층 o
- 코드에 대한 주석 설명 o
'''

import keras
import matplotlib.pyplot as plt
from keras.datasets import imdb
from keras.preprocessing.sequence import pad_sequences
from sklearn.model_selection import train_test_split

# 데이터 전처리 및 단어사전, 단어 개수 제한
(train_input, train_target), (test_input, test_target) = imdb.load_data(num_words=500)
train_input, val_input, train_target, val_target = train_test_split(
    train_input, train_target, test_size=0.2, random_state=42)

train_seq = pad_sequences(train_input, maxlen=100)
val_seq = pad_sequences(val_input, maxlen=100)

# 모델 생성
model_lstm = keras.Sequential()
model_lstm.add(keras.layers.Input(shape=(100,))) # 입력층
model_lstm.add(keras.layers.Embedding(500, 16)) # 은닉층
# 드랍아웃 층
model_lstm.add(keras.layers.LSTM(8, dropout=0.4))
model_lstm.add(keras.layers.Dense(1, activation='sigmoid')) # 출력층
model_lstm.summary()

model_lstm.compile(optimizer='adam', loss='binary_crossentropy',
                   metrics=['accuracy'])

# 콜백 포인트 (모델 저장, 파라미터 복원)
checkpoint_cb = keras.callbacks.ModelCheckpoint('./Day14/models/Qbest-lstm-model.keras',
                                                save_best_only=True)
early_stopping_cb = keras.callbacks.EarlyStopping(patience=5,
                                                  restore_best_weights=True)
# 혼자 공부할 때 넣었던 콜백 포인트입니다. loss 값이 극적으로 줄지 않는 구간에서 LR를 줄여서 미세조정 학습을 합니다.
lr_scheduler_cb = keras.callbacks.ReduceLROnPlateau(monitor='val_loss', factor=0.5, patience=3)

history = model_lstm.fit(train_seq, train_target, epochs=150, batch_size=64,
                         validation_data=(val_seq, val_target),
                         callbacks=[checkpoint_cb, early_stopping_cb, lr_scheduler_cb])

# 훈련/검증 손실곡선
plt.plot(history.history['loss'], label='train')
plt.plot(history.history['val_loss'], label='val')
plt.title('LSTM')
plt.xlabel('epoch')
plt.ylabel('loss')
plt.legend()
plt.show()

# 최고 파라미터 값
print("\n==== 모델 evaluate ====")
print(model_lstm.evaluate(val_seq, val_target))

'''
LROnPlateau 전 모델 evaluate
[0.4223286211490631, 0.8090000152587891]

이후 모델 evaluate
[0.41592904925346375, 0.8091999888420105]

엄청나게 극적인 변동이 없는 것으로 보아 (물론 loss값과 accuracy 값이 아주 약간 긍정적인 방향으로 갔음), 
학습률을 줄여 미세조정이 굳이 필요 없다는 뜻이므로, 
이미 최적의 파라미터에 가깝다는 뜻입니다.
'''