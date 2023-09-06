import sys
from heapq import heappush, heappop
from collections import defaultdict
input = sys.stdin.readline
inf = sys.maxsize

def calc_dist(st,ed):
    sdt = [inf] * (n+1)
    sdt[st] = 0
    q = []
    heappush(q,(sdt[st],st)) # 거리, 시작점
    while q:
        dis,cur = heappop(q)
        if sdt[cur] != dis:
            continue
        for d,nxt in graph[cur]:
            if sdt[nxt] <= sdt[cur] + d:
                continue
            sdt[nxt] = sdt[cur] + d
            heappush(q,(sdt[nxt],nxt))
    return sdt[ed]

n,m,x = map(int,input().split())
graph = defaultdict(list)
for _ in range(m):
    u,v,w = map(int,input().split())
    graph[u].append((w,v))
    
dist_list = []
for i in range(1,n+1):
    dist_list.append(calc_dist(i,x) + calc_dist(x,i))
            
print(max(dist_list))