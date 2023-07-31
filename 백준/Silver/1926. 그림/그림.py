from collections import deque
import sys
input = sys.stdin.readline

row, col = map(int,input().split())

graph = []
for _ in range(row):
    graph.append(list(map(int,input().split())))

visited = [[0]*col for _ in range(row)] 

dy = [1,-1,0,0]
dx = [0,0,1,-1]

count = 0
size_list = []

def bfs(y,x):
    visited[y][x] = 1
    c = 1
    q = deque([(y,x)])
    while q:
        r1,c1 = q.popleft()
        for d in range(4):
            ny = r1 + dy[d]
            nx = c1 + dx[d]
            if nx < 0 or ny < 0 or nx > col - 1 or ny > row - 1:
                continue
            if graph[ny][nx] == 1 and visited[ny][nx] == 0:
                visited[ny][nx] = 1
                c += 1
                q.append((ny,nx))
    size_list.append(c)
                
for r in range(row):
    for c in range(col):
        if graph[r][c] == 1 and visited[r][c] == 0:
            bfs(r,c)
            count += 1

print(count)
if size_list:
    print(max(size_list))
else:
    print(0)
                