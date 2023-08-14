import sys
input = sys.stdin.readline

def digit_count(s):
    sum = 0
    # 문자열에서 숫자만 추출하여 합을 계산
    for c in s:
        if c.isdigit():
            sum += int(c)
    return sum

serial_num = [input().rstrip() for _ in range(int(input()))]
serial_num.sort(key = lambda x: (len(x),digit_count(x),x))
for sn in serial_num:
    print(sn) 