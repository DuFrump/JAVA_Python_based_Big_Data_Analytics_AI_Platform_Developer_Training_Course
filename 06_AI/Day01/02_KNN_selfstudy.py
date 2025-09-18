from sklearn.neighbors import KNeighborsClassifier

# --- 데이터 준비 (제가 드릴 부분) ---

# 사과 데이터 (총 10개)
apple_weight = [130, 145, 150, 165, 170, 180, 185, 190, 200, 210]
apple_diameter = [6.5, 6.8, 7.0, 7.2, 7.5, 7.6, 7.8, 8.0, 8.1, 8.3]

# 오렌지 데이터 (총 10개)
orange_weight = [160, 170, 175, 185, 195, 205, 215, 220, 230, 240]
orange_diameter = [7.8, 8.1, 8.2, 8.5, 8.8, 9.0, 9.2, 9.5, 9.8, 10.1]

# --- 여기서부터 직접 코드를 작성해보세요! ---

weight = apple_weight + orange_weight
diameter = apple_diameter + orange_diameter

fruit_data = [[w, d] for w, d in zip(weight, diameter)]

fruit_target = [0]*10 + [1]*10

kn = KNeighborsClassifier()

kn.fit(fruit_data, fruit_target)

print(f"정확도 : {kn.score(fruit_data, fruit_target)}") 

# 4. 새로운 과일 예측
new_fruit = [[175, 8.0], [168, 7.5], [145, 7.5]]
prediction = kn.predict(new_fruit)

print(f"\n새로운 과일 [무게 175g, 지름 8.0cm] 예측 결과: {prediction}")
print("(0: 사과, 1: 오렌지)")