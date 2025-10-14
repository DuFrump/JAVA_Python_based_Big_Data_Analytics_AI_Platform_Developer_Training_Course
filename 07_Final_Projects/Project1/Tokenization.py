import matplotlib.pyplot as plt

from matplotlib import font_manager, rc
font_path = 'C:/Windows/Fonts/malgun.ttf'
font_name = font_manager.FontProperties(fname=font_path).get_name()
rc('font', family=font_name)
plt.rcParams['axes.unicode_minus'] = False

# 데이터 불러오기
topics = ['기술/IT', '스포츠', '영화/미디어', '경제/제테크', '일상/여행', 'NaN']

file_map = {
    '기술/IT': '기술_IT.txt', 
    '스포츠': '스포츠.txt', 
    '영화/미디어': '영화_미디어.txt', 
    '경제/제테크': '경제_제테크.txt', 
    '일상/여행': '일상_여행.txt',
    'NaN' : 'NaN.txt'
}

base_dir = './Project1/dataSet/created_dataset'

# 데이터 전처리
import re

def clean_text(text):
    text = re.sub(r'\d+', '', text)
    text = re.sub(r"[!,.']", '', text)
    return text

cleaned_texts = [clean_text(doc) for doc in file_map]
print(cleaned_texts)