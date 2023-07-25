from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

t = int(input())

dy = [0,0,-1,1]
dx = [-1,1,0,0]

def dfs(i,j):
    visited[i][j] = 1
    for k in range(4):
        ny = i + dy[k]
        nx = j + dx[k]
        if ny < 0 or nx < 0 or ny > m-1 or nx > n-1:
            continue
        if graph[ny][nx] == 1 and visited[ny][nx] == 0:
            dfs(ny,nx)

for _ in range(t):
    n,m,bachu = map(int,input().split())
    count = 0
    
    graph = [[0]*n for _ in range(m)]
    for _ in range(bachu):
        x,y = map(int,input().split())
        graph[y][x] = 1
        
    visited = [[0]*n for _ in range(m)]
    
    for i in range(m):
        for j in range(n):
            if graph[i][j] == 1 and visited[i][j] == 0:
                count += 1
                dfs(i,j)
    print(count)
