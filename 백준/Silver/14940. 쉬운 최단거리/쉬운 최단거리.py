from sys import stdin
from collections import deque
input = stdin.readline

n,m = map(int,input().split())
board = []
for i in range(n):
    l = list(map(int,input().split()))
    for j in range(m):
        if l[j] == 2:
            st = (i,j)
    board.append(l)

dist = [[-1] * m for _ in range(n)]
dist[st[0]][st[1]] = 0
dq = deque([(st[0],st[1])])
while dq:
    x,y = dq.popleft()
    for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < m:
            if board[nx][ny] != 0 and dist[nx][ny] == -1:
                dist[nx][ny] = dist[x][y] + 1
                dq.append((nx,ny))

for i in range(n):
    for j in range(m):
        if board[i][j] == 0:
            print(0,end=" ")
        else:
            print(dist[i][j],end=" ")
    print()