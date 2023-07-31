from collections import deque
import sys
input = sys.stdin.readline

n = int(input())

graph = []
for _ in range(n):
    graph.append(list(input().rstrip()))

visited = [[0]*n for _ in range(n)] 
visited2 = [[0]*n for _ in range(n)] 

dy = [1,-1,0,0]
dx = [0,0,1,-1]

count1 = 0
count2 = 0

def bfs(row,col,color):
    q = deque([(row,col)])
    while q:
        r1,c1 = q.popleft()
        for d in range(4):
            ny = r1 + dy[d]
            nx = c1 + dx[d]
            if nx < 0 or ny < 0 or nx > n - 1 or ny > n - 1:
                continue
            if graph[ny][nx] == color and visited[ny][nx] == 0:
                visited[ny][nx] = 1
                q.append((ny,nx))

def bfs2(row,col,color):
    q = deque([(row,col)])
    while q:
        r1,c1 = q.popleft()
        for d in range(4):
            ny = r1 + dy[d]
            nx = c1 + dx[d]
            if nx < 0 or ny < 0 or nx > n - 1 or ny > n - 1:
                continue
            if color == 'R' or color == 'G':
                if graph[ny][nx] == 'R' and visited2[ny][nx] == 0 or graph[ny][nx] == 'G' and visited2[ny][nx] == 0: 
                    visited2[ny][nx] = 1
                    q.append((ny,nx))
            else:
                if graph[ny][nx] == color and visited2[ny][nx] == 0:
                    visited2[ny][nx] = 1
                    q.append((ny,nx))
                
for r in range(n):
    for c in range(n):
        if visited[r][c] == 0:
            bfs(r,c,graph[r][c])
            count1 += 1
        if visited2[r][c] == 0:
            bfs2(r,c,graph[r][c])
            count2 += 1
        
print(count1,count2)
