import sys
from collections import defaultdict
from heapq import heappush, heappop
input = sys.stdin.readline
inf = sys.maxsize

def Dijkstra(limit):
    sdt = [inf] * (n+1)
    sdt[a] = 0
    q = []
    heappush(q,(sdt[a],a)) # 거리, 시작점
    while q:
        dis,cur = heappop(q)
        if sdt[cur]!= dis:
            continue
        for dis2,nxt in graph[cur]:
            if dis2 > limit:
                continue
            dis2 += dis
            if sdt[nxt] <= dis2:
                continue
            sdt[nxt] = dis2
            heappush(q,(dis2,nxt))
            
    if sdt[b] > c:
        return False
    return True

n,m,a,b,c = map(int,input().split())
graph = defaultdict(list)
low_cost = 1
high_cost = 0

for _ in range(m):
    s,e,cost = map(int,input().split())
    graph[s].append((cost,e))
    graph[e].append((cost,s))
    high_cost = max(high_cost, cost)

while low_cost < high_cost:
    mid = (low_cost + high_cost) // 2
    if Dijkstra(mid):
        high_cost = mid
    else:
        low_cost = mid + 1
        
if Dijkstra(low_cost):
    print(low_cost)
else:
    print(-1)