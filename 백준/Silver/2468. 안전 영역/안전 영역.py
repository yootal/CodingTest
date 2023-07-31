import sys
input = sys.stdin.readline
from collections import deque

n = int(input())

dy,dx = [1,-1,0,0],[0,0,1,-1]
visited = [[0]*n for _ in range(n)]
graph = []

for _ in range(n):
    graph.append(list(map(int,input().split())))
    
max_value = max(max(g) for g in graph)

def bfs(r,c,check):
    visited[r][c] = check
    q = deque([(r,c)])
    while q:
        r1,c1 = q.popleft()
        for i in range(4):
            ny = r1 + dy[i]
            nx = c1 + dx[i]
            if ny < 0 or ny > n-1 or nx < 0 or nx > n-1:
                continue 
            if visited[ny][nx] < check and graph[ny][nx] >= check:
                visited[ny][nx] = check
                q.append((ny,nx))

counts = []
for i in range(1,max_value+1):
    count = 0
    for y in range(n):
        for x in range(n):
            if graph[y][x] >= i:
                if visited[y][x] < i and graph[y][x] >= i: 
                    bfs(y,x,i)
                    count += 1
    counts.append(count)

print(max(counts))

        
