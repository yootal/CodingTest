from sys import stdin, maxsize
from collections import defaultdict, deque
input = stdin.readline

n,d = map(int,input().split())
path = defaultdict(list)
for _ in range(n):
    s,e,c = map(int,input().split())
    path[s].append((e,c))

dist = [maxsize] * (d+1)

dq = deque()
dq.append((0,0))
dist[0] = 0
while dq:
    cur,total = dq.popleft()
    if dist[cur] < total:
        continue
    if path[cur]:
        for nxt,cost in path[cur]:
            if nxt <= d:
                if dist[nxt] > dist[cur] + cost:
                    dist[nxt] = dist[cur] + cost
                    dq.append((nxt,dist[nxt]))
    if cur + 1 <= d:
        if dist[cur+1] > dist[cur] + 1: 
            dist[cur+1] = dist[cur] + 1
            dq.append((cur + 1,dist[cur+1]))

print(dist[d])