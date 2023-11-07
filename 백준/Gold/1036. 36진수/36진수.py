from sys import stdin
input = stdin.readline

def change(x):
    if x.isupper():
        return int(ord(x) - 55)
    return int(x)

def base36_to_decimal(base36_number):
    base36_chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'   # 36진수 문자
    decimal_number = 0
    base = 36
    for char in base36_number:
        decimal_number = decimal_number * base + base36_chars.index(char)
    return decimal_number

def decimal_to_base36(decimal_number):
    if decimal_number == 0:
        return '0'  # 0의 경우는 예외 처리
    base36_chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ'   # 36진수 문자
    result = ''
    while decimal_number > 0:
        decimal_number, remainder = divmod(decimal_number, 36)
        result = base36_chars[remainder] + result
        
    return result

idx = [0] * 36
n = int(input())
num = []
for _ in range(n):
    x = list(input().rstrip())
    for i in range(len(x)):
        idx[change(x[i])] += 36**(len(x)-i-1)*(35-change(x[i]))
    num.append(x)
sorted_num = sorted(enumerate(idx),key= lambda x: (x[1]),reverse=True)
k = int(input())

change_set = set()
for i in range(k):
    change_set.add(sorted_num[i][0])
    
total = 0
for num2 in num:
    for i in range(len(num2)):
        if change(num2[i]) in change_set:
            num2[i] = 'Z'
    total += base36_to_decimal(''.join(num2))
    
print(decimal_to_base36(total))