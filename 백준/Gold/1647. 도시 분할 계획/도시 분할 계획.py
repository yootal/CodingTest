import sys
from collections import defaultdict
from heapq import heappush, heappop
input = sys.stdin.readline

n,m = map(int,input().split())
graph = defaultdict(list)
check = [False] * (n+1)

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
    
check[1] = True
q = []
for nxt, cost in graph[1]:
    heappush(q,(cost,1,nxt))

cnt = 0
total_cost = 0
max_cost = 0

while cnt < n-1:
    c,a,b = heappop(q)
    if check[b]:
        continue
    max_cost = max(max_cost,c)
    total_cost += c
    check[b] = True
    cnt += 1
    for nxt,cost in graph[b]:
        if not check[nxt]:
            heappush(q,(cost,b,nxt))
            
print(total_cost - max_cost)