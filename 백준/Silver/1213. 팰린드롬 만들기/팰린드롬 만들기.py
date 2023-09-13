import sys
from collections import Counter
input = sys.stdin.readline

name = input().rstrip()
char_cnt = Counter(name)
cnt = 0
result = ''
mid = ''
char_cnt = list(char_cnt.items())
for k,v in char_cnt:
    if v % 2 == 1:
        cnt += 1
        mid = k
        if cnt > 1:
            print("I'm Sorry Hansoo")
            exit()

for k,v in sorted(char_cnt):
    result += (k*(v//2))
print(result + mid + result[::-1])
        