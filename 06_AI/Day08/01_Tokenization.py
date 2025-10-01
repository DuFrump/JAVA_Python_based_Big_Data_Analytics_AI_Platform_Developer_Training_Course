sample_text = '''
    Hello! This is an example sentence for NLP preprocessing.
    Let's clean, tokenize, and get ready for modeling!
'''

import re

def clean_text(text):
    text = text.lower() # 소문자화
    text = re.sub(r'\d+', '', text) # 숫자 제거
    text = re.sub(r"[!,.']", '', text) # 특수문자 제거
    text = text.strip() # 양쪽 공백 제거
    return text

cleaned = clean_text(sample_text)
print(cleaned)

# 방법1 split()

tokens = cleaned.split()
print('----------직접 처리----------')
print(tokens)
print()

# -------------------------------------------------

# 방법 2: NLTK word_tokenize (영어 특화)
# pip install nltk

import nltk
from nltk.tokenize import word_tokenize

# nltk.download('punkt')
# nltk.download('punkt_tab')

tokens_nltk = word_tokenize(cleaned)

print('------------nltk 사용------------')
print(tokens_nltk)
print()

# 한국어도 해보기
text_ko = """
안녕하세요. 자연어 처리를 배우고 있어요!
저의 취미는 책을 읽는 것입니다.
여러분은 무슨 음식을 좋아하나요?
"""

print('----------nltk 사용---------')
tokens_nltk_ko = word_tokenize(text_ko)
print(tokens_nltk_ko)
print()

print('----------스플릿 사용--------')
tokens_ko_split = text_ko.split()
print(tokens_ko_split)
print()

# ----------------------------------------------------

# 방법 3: spaCy (고급분석)
# pip install spacy
# python -m spacy download en_core_web_sm
import spacy
from spacy.cli import download

nlp = spacy.load('en_core_web_sm')

doc = nlp(cleaned)

tokens_spacy = [token.text for token in doc]
print('---------spacy 사용---------')
