import sys
input=sys.stdin.readline
from collections import deque

dx,dy = [-1,1,0,0],[0,0,-1,1]

def check(board):
    while True:
        points = []
        visited = [[False] * 6 for _ in range(12)]
        for i in range(12):
            for j in range(6):
                if board[i][j] != 0:
                    record = bfs(board[i][j],i,j,visited)
                    if len(record) >= 4:
                        points.append(record)
        if len(points) == 0:
            return
        pop_block(points)
        gravity(board)
    
def bfs(cn,i,j,visited):
    visited[i][j] = True
    record = [(i,j)]
    q = deque()
    q.append((i,j))
    while q:
        row, col = q.popleft()
        for i in range(4):
            nx = row + dx[i]
            ny = col + dy[i]
            if 0 <= nx < 12 and 0 <= ny < 6:
                if board[nx][ny] == cn and not visited[nx][ny]:
                    visited[nx][ny] = True
                    q.append((nx,ny))
                    record.append((nx,ny)) 
    if len(record) >= 4:
        return record
    else:
        return []
    
def gravity(board):
    num = [[] for _ in range(6)]
    for col in range(6):
        for row in range(12):
            if board[row][col] != 0:
                num[col].append(board[row][col])
                board[row][col] = 0
    for col in range(6):
        for row in range(11,11-len(num[col]),-1):
            board[row][col] = num[col].pop()

def pop_block(points):
    global count
    count += 1
    for record in points:
        for i,j in record:
            board[i][j] = 0
    
board = [[0] * 6 for _ in range(12)]
count = 0
for i in range(12):
    inp = input().rstrip()
    for j in range(6):
        if inp[j] == 'R':
            board[i][j] = 1
        elif inp[j] == 'G':
            board[i][j] = 2
        elif inp[j] == 'B':
            board[i][j] = 3
        elif inp[j] == 'P':
            board[i][j] = 4
        elif inp[j] == 'Y':
            board[i][j] = 5
            
check(board)
print(count)
