import sys
from collections import deque
input = sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

def limit_check(i,j):
    return i < 0 or i >= n or j < 0 or j >=m

n,m = map(int,input().split())
board = [input().rstrip() for _ in range(n)]
lake = [[0] * m for _ in range(n)]
swan_vis = [[0] * m for _ in range(n)]
water_vis = [[0] * m for _ in range(n)]
water_q = deque()
ice_q2 = deque()
swan_q = deque()
swan_q2 = deque()

ans = 0
swan_point = []
for i in range(n):
    for j in range(m):
        if board[i][j] == 'X':
            lake[i][j] = 1
        if board[i][j] == 'L':
            swan_point.append((i,j))
        if board[i][j] != 'X':
            water_q.append((i,j))
            
sx,sy = swan_point[0]
ex,ey = swan_point[1]
swan_q.append((sx,sy))
swan_vis[sx][sy] = 1

while True:
    while swan_q:
        x,y = swan_q.popleft()
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            if limit_check(nx,ny) or swan_vis[nx][ny]:
                continue
            if lake[nx][ny] == 1:
                swan_vis[nx][ny] = 1
                swan_q2.append((nx,ny))
                continue
            elif nx == ex and ny == ey:
                print(ans)
                exit()
            swan_vis[nx][ny] = 1
            swan_q.append((nx,ny))
            
    while swan_q2:
        sx2,sy2 = swan_q2.popleft()
        swan_q.append((sx2,sy2))
        
    while water_q:
        wx,wy = water_q.popleft()
        water_vis[wx][wy] = 1
        for dx,dy in d:
            nx = wx + dx
            ny = wy + dy
            if limit_check(nx,ny) or water_vis[nx][ny]:
                continue
            if lake[nx][ny] == 1:
                ice_q2.append((nx,ny))
            water_vis[nx][ny] = 1

    while ice_q2:
        wx,wy = ice_q2.popleft()
        lake[wx][wy] = 0
        water_q.append((wx,wy))
        
    ans += 1