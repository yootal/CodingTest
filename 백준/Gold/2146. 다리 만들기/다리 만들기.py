import sys
from collections import deque
input = sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

n = int(input())
land = [list(map(int,input().split())) for _ in range(n)]
vis = [[False]* n for _ in range(n)]    

def limit_check(i,j):
    return i < 0 or i >= n or j < 0 or j >= n

def island():
    island_num = 1
    for i in range(n):
        for j in range(n):
            if vis[i][j] or land[i][j] == 0:
                continue
            q = deque()
            q.append((i,j))
            vis[i][j] = True
            while q:
                px,py = q.popleft()
                land[px][py] = island_num
                for dx,dy in d:
                    nx = px + dx
                    ny = py + dy
                    if limit_check(nx,ny) or vis[nx][ny] or land[nx][ny] == 0:
                        continue
                    q.append((nx,ny))
                    vis[nx][ny] = True
            island_num += 1
            
island()
dist = [[-1]* n for _ in range(n)]     
q = deque()
for i in range(n):
    for j in range(n):
        if land[i][j] != 0:
            dist[i][j] = 0
            q.append((i,j))

ans = sys.maxsize
while q:
    px,py = q.popleft()
    for dx,dy in d:
        nx = px + dx
        ny = py + dy
        if limit_check(nx,ny) or land[nx][ny] == land[px][py]:
            continue
        if land[nx][ny] != 0:
            ans = min(ans, dist[nx][ny] + dist[px][py])
        else:
            land[nx][ny] = land[px][py]
            dist[nx][ny] = dist[px][py] + 1
            q.append((nx,ny))

print(ans)