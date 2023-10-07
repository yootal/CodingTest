from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

def Dijkstra():
    hq = []
    heappush(hq,(0,1)) # 거리, 시작점
    heappush(dist[1],0) # 거리 저장
    while hq:
        d,cur = heappop(hq)
        for d2,nxt in graph[cur]:
            total = d + d2
            # k개가 안찼으면 그냥 넣고
            if len(dist[nxt]) < k:
                heappush(hq,(total,nxt))
                heappush(dist[nxt],-total)
            # 다 찼으면 비교해서 교체
            else:
                if dist[nxt][0] < -total:
                    heappop(dist[nxt])
                    heappush(hq,(total,nxt))
                    heappush(dist[nxt],-total)
                    
n,m,k = map(int,input().split())
graph = defaultdict(list)
dist = defaultdict(list)
for i in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((c,b))

Dijkstra()

for i in range(1,n+1):
    if len(dist[i]) < k:
        print(-1)
    else:
        print(-dist[i][0])