import sys
from collections import deque
input=sys.stdin.readline
inf = sys.maxsize

d = [(-1,0),(1,0),(0,-1),(0,1)]

def bfs():
    visited[k][0][0] = 1
    q = deque()
    q.append((0,0,1,k)) # x,y,time,wall
    while q:
        x,y,time,wall = q.popleft()
        
        if x == n-1 and y == m-1:
            return visited[wall][x][y]
        
        for dx,dy in d:
            nx = x + dx
            ny = y + dy
            
            if ny < 0 or ny > m - 1 or nx < 0 or nx > n - 1:
                continue
            
            if board[nx][ny] == 0 and visited[wall][nx][ny] > time + 1:
                visited[wall][nx][ny] = time + 1
                q.append((nx,ny,time+1,wall))
                
            elif board[nx][ny] == 1 and wall and visited[wall-1][nx][ny] > time + 1:
                if time % 2 == 1: # 낮
                    visited[wall-1][nx][ny] = time + 1
                    q.append((nx,ny,time+1,wall-1))
                else: # 밤
                    q.append((x,y,time+1,wall))
    return -1
    
n,m,k = map(int,input().split())
board = [list(map(int,input().rstrip())) for _ in range(n)]
visited = [[[inf] * m for _ in range(n)] for _ in range(k+1)]
print(bfs())
