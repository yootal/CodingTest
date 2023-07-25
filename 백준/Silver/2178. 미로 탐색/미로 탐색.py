from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

dy = [1,0,-1,0]
dx = [0,1,0,-1]

n,m = map(int,input().split())
board = [input().rstrip() for _ in range(n)]
visited = [[0]*m for _ in range(n)]
count = 0
counts = []

def bfs(i,j):
    q = deque([(i,j)])
    visited[i][j] = 1
    while q:
        row, col = q.popleft()
        for k in range(4):
            ny = row + dy[k]
            nx = col + dx[k]
            if ny < 0 or nx < 0 or ny > n-1 or nx > m-1:
                continue
            elif board[ny][nx] == '1' and visited[ny][nx] == 0:
                visited[ny][nx] = visited[row][col] + 1
                q.append((ny,nx))
    return visited[n-1][m-1]

print(bfs(0,0))