import sys
input = sys.stdin.readline
from collections import defaultdict
from heapq import heappush, heappop

n,m = map(int,input().split())
graph = defaultdict(list)

for _ in range(m+1):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
    
check1 = [False] * (n+1)
check2 = [False] * (n+1)
check1[0] = True
check2[0] = True

max_q = []
min_q = []
for nxt,cost in graph[0]:
    heappush(min_q,(-cost,0,nxt))
    heappush(max_q,(cost,0,nxt))
    
min_ans = 0
max_ans = 0

cnt = 0
while cnt < n:
    c,a,b = heappop(min_q)
    if check1[b]:
        continue
    if c == 0:
        min_ans += 1
    cnt += 1
    check1[b] = True
    for nxt,cost in graph[b]:
        if not check1[nxt]:
            heappush(min_q,(-cost,b,nxt))

cnt = 0
while cnt < n:
    c,a,b = heappop(max_q)
    if check2[b]:
        continue
    if c == 0:
        max_ans += 1
    cnt += 1
    check2[b] = True
    for nxt,cost in graph[b]:
        if not check2[nxt]:
            heappush(max_q,(cost,b,nxt))
            
print(max_ans*max_ans - min_ans*min_ans)
    