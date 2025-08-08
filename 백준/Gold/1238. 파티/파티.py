from sys import stdin,maxsize
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

n,m,x = map(int,input().split())
graph = defaultdict(list)
for _ in range(m):
    s,e,w = map(int,input().split())
    graph[s].append((w,e))
    
def dijkstra(st,en):
    sdt = [maxsize] * (n+1)
    sdt[st] = 0
    hq = []
    heappush(hq,(sdt[st],st))
    while hq:
        t1,cur = heappop(hq)
        if sdt[cur] != t1:
            continue
        for t2,nxt in graph[cur]:
            if sdt[nxt] > sdt[cur] + t2:
                sdt[nxt] = sdt[cur] + t2
                heappush(hq,(sdt[nxt],nxt))
    if st == en:
        return sdt
    else:
        return sdt[en]
        
round = [0] * (n+1)
for st in range(1,n+1):
    if st == x:
        dists = dijkstra(st,x)
        for st in range(1,n+1):
            round[st] += dists[st]
    else:
        round[st] += dijkstra(st,x)
        
print(max(round))