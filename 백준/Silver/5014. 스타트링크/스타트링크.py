import sys
from collections import deque
input = sys.stdin.readline

f,s,g,u,d = map(int,input().split())
up_down = [u,-d]
vis = [0] * f

def bfs(now):
    vis[now] = 1
    q = deque([now])
    while q:
        p = q.popleft()
        for i in range(2):
            np = p + up_down[i]
            if 0 <= np < f:
                if vis[np] == 0:
                    vis[np] = vis[p] + 1
                    q.append(np)

bfs(s-1)
if vis[g-1] == 0:
    print("use the stairs")  
else:
    print(vis[g-1]-1)    