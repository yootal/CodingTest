from sys import stdin, maxsize
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

def Dijkstra():
    sdt = [maxsize] * (n+1)
    sdt[1] = 0
    hq = []
    heappush(hq,(sdt[1],1))
    while hq:
        time,cur = heappop(hq)
        if sdt[cur]!= time:
            continue
        for nxt_time,nxt in graph[cur]:
            if (time - nxt_time) % m == 0:
                move_time = ((time - nxt_time) // m) * m + nxt_time
                if sdt[nxt] > move_time + 1:
                    sdt[nxt] = move_time + 1
                    heappush(hq,(sdt[nxt],nxt))    
            else:
                move_time = ((time - nxt_time) // m + 1) * m + nxt_time
                if sdt[nxt] > move_time + 1:
                    sdt[nxt] = move_time + 1
                    heappush(hq,(sdt[nxt],nxt))
    return sdt[n]

n,m = map(int,input().split())
graph = defaultdict(list)
for i in range(m):
    a,b = map(int,input().split())
    graph[a].append((i,b))
    graph[b].append((i,a))
    
print(Dijkstra())
