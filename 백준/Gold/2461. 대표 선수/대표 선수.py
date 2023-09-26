import sys
from collections import deque
from heapq import heappush, heappop
input = sys.stdin.readline
    
n,m = map(int,input().split())
group = []
for i in range(n):
    level = list(map(int,input().split()))
    level.sort()
    group.append(deque(level))
    
q = []
mn = sys.maxsize
mx = 0

for i in range(n):
    v = group[i].popleft()
    mx = max(mx, v)
    mn = min(mn, v)
    heappush(q, (v, i))
    
ans = mx - mn

while q:
    pre_mn,i = heappop(q)
    if not group[i]:
        break
    new = group[i].popleft()
    heappush(q,(new,i))
    
    if mx < new:
        mx = new
    mn = q[0][0]
    ans = min(ans, mx - mn)

print(ans)