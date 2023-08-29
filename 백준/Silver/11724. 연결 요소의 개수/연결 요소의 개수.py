import sys
from collections import deque 
input = sys.stdin.readline

n,m = map(int,input().split())
line = [[] for _ in range(n+1)]
for _ in range(m):
    s,e = map(int,input().split())
    line[s].append(e)
    line[e].append(s)

vis = [False] * n

cnt = 0
for i in range(1,n+1):
    if not vis[i-1]:
        cnt += 1
        vis[i-1] = True
        q = deque([i])
        while q:
            pq = q.popleft()
            for p in line[pq]:
                if not vis[p-1]:
                    vis[p-1] = True
                    q.append(p)
                    
print(cnt)
        