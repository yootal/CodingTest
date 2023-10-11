from sys import stdin
input = stdin.readline

d = [(1,0),(-1,0),(0,1),(0,-1)]

def count():
    global max_cnt
    for i in range(n):
        for j in range(n):
            cur = board[i][j]
            ni = i
            nj = j
            cnt1 = 0
            cnt2 = 0
            while 0 <= nj < n and board[i][nj] == cur:
                cnt1 += 1
                nj += 1
            while 0 <= ni < n and board[ni][j] == cur:
                cnt2 += 1
                ni += 1
            max_cnt = max(max_cnt,cnt1,cnt2)

n = int(input())
board = [list(input().rstrip()) for _ in range(n)]

max_cnt = 0
for i in range(n):
    for j in range(n):
        cur = board[i][j]
        for dx,dy in d:
            nx = i + dx
            ny = j + dy
            if 0 <= nx < n and 0 <= ny < n:
                if board[nx][ny] != board[i][j]:
                    temp = board[i][j]
                    board[i][j] = board[nx][ny]
                    board[nx][ny] = temp
                    count()
                    temp = board[i][j]
                    board[i][j] = board[nx][ny]
                    board[nx][ny] = temp
                    
print(max_cnt)