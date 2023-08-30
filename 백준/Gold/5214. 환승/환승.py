import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n,k,m = map(int,input().split())
hyper_tube = defaultdict(list)
station = defaultdict(list)
for i in range(m):
    info = list(map(int,input().split()))
    for j in info:
        station[j].append(i)
        hyper_tube[i].append(j)

vis_station = [0] * (n+1)
vis_hyper = [False] * (m+1)

def bfs():
    vis_station[1] = 1
    q = deque([1])
    while q:
        now = q.popleft()
        next_hyper = []
        for hi in station[now]:
            if not vis_hyper[hi]:
                next_hyper.append(hi)
                vis_hyper[hi] = True
        for h in next_hyper:
            for si in hyper_tube[h]:
                if vis_station[si] == 0:
                    vis_station[si] = vis_station[now] + 1
                    q.append(si)

bfs()
print(-1 if vis_station[n] == 0 else vis_station[n])