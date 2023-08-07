import sys
input=sys.stdin.readline
from collections import deque

dy,dx = [-1,1,0,0],[0,0,-1,1]

n,m,k = map(int,input().split())
MAX = float('inf')
board = [list(map(int,input().strip())) for _ in range(n)]
visited = [[[MAX]*(k+1) for _ in range(m)] for _ in range(n)]
visited[0][0][k] = 0
q = deque()
q.append((0,0,1,k))
result = MAX

while q:
    x,y,time,wall = q.popleft()
    if (x, y) == (m-1, n-1) :
        result = min(result, time)
        continue
    
    daytime = time % 2
    for i in range(4):
        ny = y + dy[i]
        nx = x + dx[i]
        if -1 < nx < m and -1 < ny < n:
            if board[ny][nx] == 0 and visited[ny][nx][wall] > time:
                visited[ny][nx][wall] = time
                q.append((nx,ny,time+1,wall))
            if board[ny][nx] == 1 and wall and visited[ny][nx][wall-1] > time:
                if daytime:
                    visited[ny][nx][wall-1] = time
                    q.append((nx,ny,time+1,wall-1))
                else:
                    q.append((x,y,time+1,wall))

print(result if result < MAX else -1)