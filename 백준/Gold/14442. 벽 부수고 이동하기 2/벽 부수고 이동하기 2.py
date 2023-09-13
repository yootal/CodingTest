import sys
input=sys.stdin.readline
from collections import deque

d = [(-1,0),(1,0),(0,-1),(0,1)]

def bfs():
    visited[k][0][0] = 1
    q = deque()
    q.append((0,0,k))
    while q:
        row,col,wall = q.popleft()
        if row == n-1 and col == m-1:
            return visited[wall][row][col]
        for dx,dy in d:
            ny = row + dy
            nx = col + dx
            if nx < 0 or nx > m - 1 or ny < 0 or ny > n - 1:
                continue
            if board[ny][nx] == '1' and wall > 0 and not visited[wall-1][ny][nx]:
                visited[wall-1][ny][nx] = visited[wall][row][col] + 1
                q.append((ny,nx,wall-1))
            elif board[ny][nx] == '0' and not visited[wall][ny][nx]:
                visited[wall][ny][nx] = visited[wall][row][col] + 1
                q.append((ny,nx,wall))
    return -1
    
n,m,k = map(int,input().split())
board = [input().rstrip() for _ in range(n)]
visited = [[[0] * m for _ in range(n)] for _ in range(k+1)]
print(bfs())