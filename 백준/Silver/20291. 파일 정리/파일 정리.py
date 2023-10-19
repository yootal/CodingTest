from sys import stdin
from collections import defaultdict
input = stdin.readline

n  = int(input())
cnt = defaultdict(int)
for _ in range(n):
    name = list(input().rstrip().split('.'))
    cnt[name[1]] += 1

for k,v in sorted(cnt.items()):
    print(k,v)