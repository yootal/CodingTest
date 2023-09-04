import sys
input = sys.stdin.readline
from collections import defaultdict
from heapq import heappush, heappop

n,m,k = map(int,input().split())
power_plant = list(map(int,input().split()))
graph = defaultdict(list)
check = [False] * (n+1)

for _ in range(m):
    u,v,w = map(int,input().split())
    graph[u].append((v,w))
    graph[v].append((u,w))
    
q = []
for pp in power_plant:
    heappush(q,(0,pp))
    
ans = 0
cnt = 0
while q:
    cost,x = heappop(q)
    if check[x]:
        continue
    ans += cost
    check[x] = True
    for nxt,cost in graph[x]:
        heappush(q,(cost,nxt))

print(ans)