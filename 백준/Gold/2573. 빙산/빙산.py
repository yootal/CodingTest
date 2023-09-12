import sys
from collections import deque
input = sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

n,m = map(int,input().split())
iceberg = [list(map(int,input().split())) for _ in range(n)]

def bfs(x,y):
    vis[x][y] = True
    q = deque()
    q.append((x,y))
    while q:
        px,py = q.popleft()
        for dx,dy in d:
            nx = px + dx
            ny = py + dy
            if 0 <= nx < n and 0 <= ny < m:
                if iceberg[nx][ny] != 0 and not vis[nx][ny]:
                    vis[nx][ny] = True
                    q.append((nx,ny))

def melt(iceberg):
    new_iceberg = [[0] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if iceberg[i][j] != 0:
                cnt = 0 
                for dx,dy in d:
                    ni = i + dx
                    nj = j + dy
                    if iceberg[ni][nj] == 0:
                        cnt += 1
                if iceberg[i][j] - cnt < 0:
                    new_iceberg[i][j] = 0
                else:
                    new_iceberg[i][j] = iceberg[i][j] - cnt
    return new_iceberg

year = 0
while True:
    vis = [[False] * m for _ in range(n)]
    lump = 0
    check = False
    for i in range(n):
        for j in range(m):
            if iceberg[i][j] != 0 and not vis[i][j]:
                lump += 1
                check = True
                bfs(i,j)
                
    if not check:
        print(0)
        break
    
    if lump >= 2:
        print(year)
        break
    
    year += 1
    iceberg = melt(iceberg)