import sys
from collections import defaultdict
input = sys.stdin.readline

n,c = map(int,input().split())
m = int(input())
truck = []
weight_limit = defaultdict(int)

for _ in range(m):
    s,e,w = map(int,input().split())
    truck.append((e,s,w))
truck.sort()

ans = 0
for e,s,w in truck:
    load_able = True
    for i in range(s,e):
        w = min(w,c - weight_limit[i])
        if w == 0:
            load_able = False
            break
    if load_able:
        ans += w
        for i in range(s,e):
            weight_limit[i] += w

print(ans)