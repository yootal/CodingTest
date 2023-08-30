import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n,m = map(int,input().split())
shed = defaultdict(list)  
vis = [False] * n
distance = [0] * n

for _ in range(m):
    e,s = map(int,input().split())
    shed[s].append(e)
    shed[e].append(s)
            
def bfs(i):
    q = deque([(i,0)])
    vis[i-1] = True            
    while q:
        pq,dis = q.popleft()
        for c in shed[pq]:
            if not vis[c-1]:
                vis[c-1] = True
                distance[c-1] = dis + 1
                q.append((c,dis + 1))
        
bfs(1)
md = max(distance)
print(distance.index(md) + 1,md,distance.count(md))  