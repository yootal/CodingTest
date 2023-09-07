import sys
from collections import defaultdict
from heapq import heappush, heappop
input = sys.stdin.readline
inf = sys.maxsize

n,m,k = map(int,input().split())
graph = defaultdict(list)
for _ in range(m):
    u,v,c = map(int,input().split())
    graph[v].append((c,u))
interview_room = list(map(int,input().split()))

sdt = [inf] * (n+1)
q = []
for ir in interview_room:
    sdt[ir] = 0
    heappush(q,(sdt[ir],ir)) # 거리, 시작점
    
while q:
    dis,cur = heappop(q)
    if sdt[cur]!= dis:
        continue
    for dis2,nxt in graph[cur]:
        if sdt[nxt] <= sdt[cur] + dis2:
            continue
        sdt[nxt] = sdt[cur] + dis2
        heappush(q,(sdt[nxt],nxt))

max_dis = max(sdt[1:])
print(sdt.index(max_dis))
print(max_dis)