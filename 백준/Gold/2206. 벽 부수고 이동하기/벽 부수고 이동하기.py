import sys
from collections import deque
input = sys.stdin.readline

d = [(1,0),(-1,0),(0,1),(0,-1)]

n,m = map(int,input().split())
board = [list(input().rstrip()) for _ in range(n)]
vis = [[[0] * m for _ in range(n)] for _ in range(2)]

def bfs(x,y):
    vis[1][x][y] = 1
    q = deque()
    q.append((x,y,1))
    while q:
        px,py,wc = q.popleft()
        if px == n-1 and py == m-1:
            return vis[wc][px][py]
        for dx,dy in d:
            nx = px + dx
            ny = py + dy
            if 0 <= nx < n and 0 <= ny < m:
                if board[nx][ny] == '0' and vis[wc][nx][ny] == 0:
                    vis[wc][nx][ny] = vis[wc][px][py] + 1
                    q.append((nx,ny,wc))
                elif wc > 0 and board[nx][ny] == '1' and vis[wc-1][nx][ny] == 0:
                    vis[wc-1][nx][ny] = vis[wc][px][py] + 1  
                    q.append((nx,ny,wc-1))
    return -1 

print(bfs(0,0))
