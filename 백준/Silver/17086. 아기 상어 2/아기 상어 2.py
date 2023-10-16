from sys import stdin
from collections import deque
input = stdin.readline

d = [(1,0),(-1,0),(0,1),(0,-1),(1,1),(-1,-1),(-1,1),(1,-1)]

n,m = map(int,input().split())
board = []
shark = []
for i in range(n):
    inp = list(map(int,input().split()))
    for j in range(m):
        if inp[j] == 1:
            shark.append((i,j))
    board.append(inp)

dq = deque(shark)
while dq:
    x,y = dq.popleft()
    for dx,dy in d:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if board[nx][ny] == 0:
                board[nx][ny] = board[x][y] + 1
                dq.append((nx,ny))

ans = max(max(row) for row in board)
print(ans-1)