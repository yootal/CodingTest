from sys import stdin
from collections import deque
input = stdin.readline

d = [(1,0),(-1,0),(0,1),(0,-1),(-1,-1),(1,1),(-1,1),(1,-1)]

def bfs(i,j):
    dq = deque()
    dq.append((i,j))
    while dq:
        x,y = dq.popleft()
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < h and 0 <= ny < w:
                if board[nx][ny] == 1 and not vis[nx][ny]:
                    vis[nx][ny] = True
                    dq.append((nx,ny))

while True:
    w,h = map(int,input().split())
    if w == 0 and h == 0:
        break
    
    board = [list(map(int,input().split())) for _ in range(h)]
    vis = [[False] * w for _ in range(h)]

    ans = 0
    for i in range(h):
        for j in range(w):
            if board[i][j] == 1 and not vis[i][j]:
                vis[i][j] = True
                bfs(i,j)
                ans += 1
    print(ans)
