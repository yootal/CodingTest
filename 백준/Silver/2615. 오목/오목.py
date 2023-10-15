from sys import stdin
input = stdin.readline
d = [(0,1),(1,0),(1,1),(-1,1)]
board = [list(map(int,input().split())) for _ in range(19)]

for i in range(19):
    for j in range(19):
        if board[i][j] != 0:
            cur = board[i][j]
            for dx,dy in d:
                cnt = 1
                nx = i + dx
                ny = j + dy
                while 0 <= nx < 19 and 0 <= ny < 19 and board[nx][ny] == cur:
                    cnt += 1
                    if cnt == 5:
                        if 0 <= i - dx < 19 and 0 <= j - dy < 19 and board[i-dx][j-dy] == cur:
                            break
                        if 0 <= nx + dx < 19 and 0 <= ny + dy < 19 and board[nx + dx][ny + dy] == cur:
                            break
                        print(cur)
                        print(i + 1, j + 1)
                        exit()
                    nx += dx
                    ny += dy

print(0)  