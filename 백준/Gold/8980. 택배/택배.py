import sys
from collections import defaultdict
input = sys.stdin.readline

n,c = map(int,input().split())
m = int(input())
truck = defaultdict(list)
weight_limit = defaultdict(int)

for _ in range(m):
    s,e,w = map(int,input().split())
    truck[e-s].append((s,e,w))
    
ans = 0
for i in range(1,n): 
    for s,e,w in truck[i]:
        possible = sys.maxsize
        limit_check = True
        for cur in range(s,e):
            if weight_limit[s] == c:
                limit_check = False
                break
            if weight_limit[cur] + w > c:
                possible = min(possible, c - weight_limit[cur]) 
            else:
                possible = min(possible, w) 
        if limit_check:
            for cur in range(s,e):
                weight_limit[cur] += possible
            ans += possible

print(ans)