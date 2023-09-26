import sys
from collections import defaultdict
input = sys.stdin.readline
    
n,m = map(int,input().split())
group = []
for i in range(1,n+1):
    level = list(map(int,input().split()))
    for l in level:
        group.append((l,i))
group.sort()

count = defaultdict(int)
check = [True] + [False] * n

en = 0
ans = sys.maxsize
n *= m
for st in range(n):
    while en < n and False in check:
        count[group[en][1]] += 1
        check[group[en][1]] = True
        en += 1
    
    if en == n:
        break
    if group[en-1][1] != group[st][1]:
        ans = min(ans,group[en-1][0] - group[st][0])
    
    count[group[st][1]] -= 1
    if count[group[st][1]] == 0:
        check[group[st][1]] = False

print(ans)
