from sys import stdin
input = stdin.readline

d = [(1,0),(-1,0),(0,1),(0,-1)]

n = int(input())
board = [list(input().rstrip()) for _ in range(n)]

max_cnt = 0
for i in range(n):
    for j in range(n):
        x,y = i,j
        while x < n and board[i][j] == board[x][j]:
            x += 1
        while y < n and board[i][j] == board[i][y]:
            y += 1
        max_cnt = max(max_cnt,x-i,y-j)
        
for i in range(n):
    for j in range(n):
        cur = board[i][j]
        for dx,dy in d:
            nx = i + dx
            ny = j + dy
            if 0 <= nx < n and 0 <= ny < n:
                if board[nx][ny] != board[i][j]:
                    board[i][j],board[nx][ny] = board[nx][ny],board[i][j]
                    x1,x2 = i,i
                    while 0 <= x1 and board[i][j] == board[x1][j]:
                        x1 -= 1
                    while x2 < n and board[i][j] == board[x2][j]:
                        x2 += 1
                    y1,y2 = j,j
                    while 0 <= y1 and board[i][j] == board[i][y1]:
                        y1 -= 1
                    while y2 < n and board[i][j] == board[i][y2]:
                        y2 += 1
                    max_cnt = max(max_cnt,x2-x1-1,y2-y1-1)
                    board[i][j],board[nx][ny] = board[nx][ny],board[i][j]
                    
print(max_cnt)