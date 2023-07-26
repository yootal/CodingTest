from collections import deque
import sys
input=sys.stdin.readline

dy = [1,-1,0,0]
dx = [0,0,1,-1]
board = []

n,m = map(int,input().split())
for _ in range(n):
    board.append(input().rstrip())
  
# 0은 파괴 가능 1은 불가능
visited = [[[0]*2 for _ in range(m)] for _ in range(n)]
visited[0][0][0] = 1

def bfs(i,j,k):
    q = deque()
    q.append((i,j,k))
    while q:
        row,col,crash = q.popleft()
        if row == n-1 and col == m-1:
            return visited[row][col][crash]
        for i in range(4):
            ny = row + dy[i] 
            nx = col + dx[i]
            if nx > m-1 or ny > n-1 or nx < 0 or ny < 0:
                continue
            # 벽 이고 벽 파괴 가능
            if board[ny][nx] == '1' and crash == 0:
                visited[ny][nx][1] = visited[row][col][0] + 1
                q.append((ny,nx,1))
            # 벽 아니고 이동 가능
            elif board[ny][nx] == '0' and visited[ny][nx][crash] == 0:
                visited[ny][nx][crash] = visited[row][col][crash] + 1 
                q.append((ny,nx,crash))

    return -1
                
print(bfs(0,0,0))