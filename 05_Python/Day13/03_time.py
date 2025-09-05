import pandas as pd

# Period 배열 만들기

pr_m = pd.period_range(start='2024-01-01', end=None, periods=3, freq='M')

print(pr_m)
print()

# 1시간 간격
pr_1h = pd.period_range(start='2024-01-01', end=None, periods=3, freq='1H')

print(pr_1h)
print()

# 2일 간격
pr_2d = pd.period_range(start='2024-01-01', end=None, periods=3, freq='2D')

print(pr_2d)
print()
 