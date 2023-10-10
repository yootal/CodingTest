from sys import stdin
from collections import deque
input = stdin.readline

d = [(1,0),(0,1)]

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
vis = [[-1] * m for _ in range(n)]

dq = deque()
dq.append((0,0))
vis[0][0] = board[0][0]
while dq:
    x,y = dq.popleft()
    for dx,dy in d:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if vis[nx][ny] >= vis[x][y] + board[nx][ny]:
                continue
            vis[nx][ny] = vis[x][y] + board[nx][ny]
            dq.append((nx,ny))
            
print(vis[n-1][m-1])