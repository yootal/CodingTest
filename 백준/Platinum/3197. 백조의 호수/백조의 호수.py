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
visited = [[0] * m for _ in range(n)]

water_q = deque()
ice_q2 = deque()
swan_q = deque()
swan_q2 = deque()
lx,ly = 0,0
ans = 0
check = False

for i in range(n):
    for j in range(m):
        if board[i][j] == 'X':
            lake[i][j] = 1
        if board[i][j] == 'L':
            lx,ly = i,j
        if board[i][j] != 'X':
            water_q.append((i,j))
            
swan_q.append((lx,ly))
swan_vis[lx][ly] = 1

while not check:
    while water_q:
        qx,qy = water_q.popleft()
        visited[qx][qy] = 1
        for dx,dy in d:
            nx = qx + dx
            ny = qy + dy
            if limit_check(nx,ny) or visited[nx][ny]:
                continue
            if lake[nx][ny] == 1:
                ice_q2.append((nx,ny))
            visited[nx][ny] = 1

    while ice_q2:
        qx,qy = ice_q2.popleft()
        lake[qx][qy] = 0
        water_q.append((qx,qy))
    ans += 1

    while swan_q:
        sx,sy = swan_q.popleft()
        for dx,dy in d:
            nsx = sx + dx
            nsy = sy + dy
            if limit_check(nsx,nsy) or swan_vis[nsx][nsy]:
                continue
            if lake[nsx][nsy] == 1:
                swan_vis[nsx][nsy] = 1
                swan_q2.append((nsx,nsy))
                continue
            elif board[nsx][nsy] == 'L':
                check = True
                break
            swan_vis[nsx][nsy] = 1
            swan_q.append((nsx,nsy))

    while swan_q2:
        sx2,sy2 = swan_q2.popleft()
        swan_q.append((sx2,sy2))
    
print(ans)
           