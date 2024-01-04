from sys import stdin
from collections import deque
input = stdin.readline

n,m = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]

def make_temp():
    temp_board = [[1] * m for _ in range(n)]
    for i in range(n):
        for j in range(m):
            if not board[i][j]:
                temp_board[i][j] = 0
                dq = deque()
                dq.append((i,j))
                while dq:
                    x,y = dq.popleft()
                    for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
                        nx = x + dx
                        ny = y + dy
                        if 0 <= nx < n and 0 <= ny < m and not board[nx][ny] and temp_board[nx][ny]:
                            temp_board[nx][ny] = 0
                            dq.append((nx,ny))
                return temp_board
 

time = 0
while True:
    if not sum([sum(row) for row in board]):
        break 
    temp_board = make_temp()
    cheese_melt = []
    for i in range(n):
        for j in range(m):
            if temp_board[i][j]:
                cnt = 0
                for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
                    nx = i + dx
                    ny = j + dy
                    if 0 <= nx < n and 0 <= ny < m:
                        if temp_board[nx][ny] == 0:
                            cnt += 1
                    if cnt >= 2:
                        cheese_melt.append((i,j))
                        break
    for mx,my in cheese_melt:
        board[mx][my] = 0  
    time += 1
print(time)