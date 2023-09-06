import sys
from heapq import heappush, heappop
from collections import defaultdict
input = sys.stdin.readline
inf = sys.maxsize

n,e = map(int,input().split())
k = int(input())
graph = defaultdict(list)
for _ in range(e):
    u,v,w = map(int,input().split())
    graph[u].append((w,v))
    
sdt = [inf] * (n+1)
sdt[k] = 0
q = []
heappush(q,(sdt[k],k)) # 거리, 시작점

while q:
    dis,cur = heappop(q)
    if sdt[cur] != dis:
        continue
    for d,nxt in graph[cur]:
        if sdt[nxt] <= sdt[cur] + d:
            continue
        sdt[nxt] = sdt[cur] + d
        heappush(q,(sdt[nxt],nxt))

for i in range(1,n+1):
    if sdt[i] == inf:
        print("INF")
    else:
        print(sdt[i])