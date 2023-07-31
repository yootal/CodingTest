import sys
input = sys.stdin.readline
from collections import deque

dy,dx = [1,-1,0,0],[0,0,1,-1]

row,col,n = map(int,input().split())

rectangle = []
counts = []
area_count = 0

visited = [[0] * col for _ in range(row)]

for _ in range(n):
    rectangle.append(list(map(int,input().split())))
    
for r in rectangle:
    for x in range(r[0],r[2]):
        for y in range(r[1],r[3]):
            visited[y][x] = 1
            
def bfs(row_,col_):
    count = 1
    visited[row_][col_] = 1
    q = deque([(row_,col_)])
    while q:
        py, px = q.popleft()
        for i in range(4):
            ny, nx = py + dy[i], px + dx[i]
            if ny < 0 or nx < 0 or ny > row - 1 or nx > col - 1:
                continue
            if visited[ny][nx] == 0:
                visited[ny][nx] = 1
                count += 1
                q.append((ny,nx))
    return count    
            
for r1 in range(row):
    for c1 in range(col):
        if visited[r1][c1] == 0:
            counts.append(bfs(r1,c1))
            area_count += 1
            
print(area_count)

counts.sort()
print(" ".join(map(str,counts)))