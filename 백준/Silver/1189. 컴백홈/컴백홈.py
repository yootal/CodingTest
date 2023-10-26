from sys import stdin
from copy import deepcopy
input = stdin.readline

n,m,k = map(int,input().split())
board = [list(input().rstrip()) for _ in range(n)]
visit = [[-1] * m for _ in range(n)]

def dfs(x,y,vis):
    global ans
    if x == 0 and y == m-1:
        if vis[x][y] == k:
            ans += 1
        return
    for dx,dy in [(-1,0),(1,0),(0,-1),(0,1)]:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if board[nx][ny] == '.' and vis[nx][ny] == -1:
                vis2 = deepcopy(vis)
                vis2[nx][ny] = vis[x][y] + 1
                dfs(nx,ny,vis2)

ans = 0
visit[n-1][0] = 1
dfs(n-1,0,visit)
print(ans)       