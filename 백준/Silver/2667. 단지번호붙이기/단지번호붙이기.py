from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

n = int(input())
board = [input().rstrip() for _ in range(n)]
visited = [[0]*n for _ in range(n)]

counts = []
count = 0

dy = [0,0,-1,1]
dx = [-1,1,0,0]

def dfs(i,j):
    global count
    visited[i][j] = 1
    count += 1
    for k in range(4):
        ny = i + dy[k]
        nx = j + dx[k]
        if ny < 0 or nx < 0 or ny > n-1 or nx > n-1:
            continue
        if board[ny][nx] == '1' and visited[ny][nx] == 0:
            dfs(ny,nx)

for i in range(n):
    for j in range(n):
        if board[i][j] == '1' and visited[i][j] == 0:
            count = 0
            dfs(i,j)
            counts.append(count)

counts.sort()
print(len(counts))
for c in counts:
    print(c)