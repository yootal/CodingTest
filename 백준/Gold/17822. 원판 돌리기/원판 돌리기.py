from sys import stdin
from collections import deque
input = stdin.readline

def rotate(x,d,k):
    for i in range(x,n+1,x):
        row = deque(board[i-1])
        for _ in range(k):
            if d == 0:
                row.appendleft(row.pop())
            else:
                row.append(row.popleft())
        board[i-1] = row

def erase(case):
    flag = False
    for i in range(n):
        for j in range(m):
            if board[i][j] and vis[i][j] != case:
                record = [(i,j)]
                vis[i][j] = case
                dq = deque([(i,j)])
                while dq:
                    x,y = dq.popleft()
                    for dx,dy in ((-1,0),(1,0),(0,-1),(0,1)):
                        nx = x + dx
                        ny = y + dy
                        if nx < 0 or nx >= n:
                            continue
                        if ny < 0:
                            ny = m-1
                        elif ny >= m:
                            ny = 0
                        if board[nx][ny] == board[x][y] and vis[nx][ny] != case:
                            vis[nx][ny] = case
                            record.append((nx,ny))
                            dq.append((nx,ny))
                if len(record) > 1:
                    flag = True
                    for px,py in record:
                        board[px][py] = 0
    
    if not flag:
        total = 0
        cnt = 0
        for i in range(n):
            for j in range(m):
                if board[i][j]:
                    total += board[i][j]
                    cnt += 1
                    
        if not cnt:
            return
        avg = total / cnt
        
        for i in range(n):
            for j in range(m):
                if not board[i][j]:
                    continue
                if board[i][j] > avg:
                    board[i][j] -= 1
                elif board[i][j] < avg:
                    board[i][j] += 1     
    
n,m,t = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(n)]
vis = [[0] * m for _ in range(n)]

for case in range(1,t+1):
    x,d,k = map(int,input().split())
    rotate(x,d,k)
    erase(case)

print(sum([sum(row) for row in board]))
