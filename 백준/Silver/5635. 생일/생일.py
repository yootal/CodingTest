import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
birthday = defaultdict(int)

for _ in range(n):
    student = list(input().rstrip().split())
    birth = list(map(int,student[1:]))
    birthday[student[0]] = birth[2] * 10000 + birth[1] * 100 + birth[0]  
max_age = min(birthday, key = lambda x: birthday[x])
min_age = max(birthday, key = lambda x: birthday[x])
print(min_age)
print(max_age)
