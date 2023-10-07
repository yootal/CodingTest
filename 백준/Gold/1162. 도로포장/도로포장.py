from sys import stdin, maxsize
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

def Dijkstra():
    sdt = [[maxsize] * (k+1) for _ in range(n+1)]
    sdt[1][k] = 0
    hq = []
    heappush(hq,(sdt[1][k],1,k))
    while hq:
        time,cur,chance = heappop(hq)
        if sdt[cur][chance] < time:
            continue
        for time2,nxt in graph[cur]:
            if sdt[nxt][chance] > sdt[cur][chance] + time2:
                sdt[nxt][chance] = sdt[cur][chance] + time2
                heappush(hq,(sdt[nxt][chance],nxt,chance))   
            if chance > 0:
                if sdt[nxt][chance-1] > sdt[cur][chance]:
                    sdt[nxt][chance-1] = sdt[cur][chance]
                    heappush(hq,(sdt[nxt][chance-1],nxt,chance-1))

    return min(sdt[n])

n,m,k = map(int,input().split())
graph = defaultdict(list)
for i in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((c,b))
    graph[b].append((c,a))
    
print(Dijkstra())