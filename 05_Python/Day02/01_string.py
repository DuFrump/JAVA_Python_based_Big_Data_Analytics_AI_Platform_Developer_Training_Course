# 문자열
# "Life is too short, you have to learn Python"
# "a"
#"123"

print()
print("----- 문자열 표현 방식 4가지 -----")
print("Hello, World!")
print('Python')
print("""Life if too short, you have to learn Python""")
print('''Life if too short, you have to learn Python''')
print()

# Python's favorite food is perl
food = "Python's favorite food is perl"
print(food)

# 에러 food = 'Python's favorite food is perl'

say = '"Python is very easy." he says.'
print(say)

food = 'Python\'s favorite food is perl'
print(food)

say = "\"Python is very easy.\" he says."
print(say)
print()

print("----- 여러줄 작성 -----")
multiline = "Life is too short\nYou have to learn Python"
print(multiline)

multiline = """
Life is too short
You have to learn Python
"""
print(multiline)

multiline = '''
Life is too short
You have to learn Python
'''
print(multiline)

multiline = "Life is too short\nYou have to learn Python"
print(multiline)
print()

print("----- 이스케이프 코드 -----")
# 자주 사용하는 코드 ---- \n \' \" \t \\
multiline = '''
Life \nis \'too\" short
You \\have to learn Python
'''
print(multiline)
