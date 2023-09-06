import sys
from heapq import heappush, heappop
from collections import defaultdict
input = sys.stdin.readline
inf = sys.maxsize

n,m = map(int,input().split())
graph = defaultdict(list)
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((c,b))
    graph[b].append((c,a))
v1, v2 = map(int,input().split())
    
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

v1_first = calc_dist(1,v1)
v1_first += calc_dist(v1,v2)
v1_first += calc_dist(v2,n)

v2_first = calc_dist(1,v2)
v2_first += calc_dist(v2,v1)
v2_first += calc_dist(v1,n)

ans = min(v1_first,v2_first)
if ans >= inf:
    print(-1)
else:
    print(ans)
    