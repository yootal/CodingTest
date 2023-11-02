from collections import deque

d = ((-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1))


def count(x, y):
    cnt = 0
    for dx, dy in d:
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < n:
            if board[nx][ny] == '*':
                cnt += 1
    board[x][y] = cnt


def check(i, j):
    q = deque()
    q.append((i, j))
    board[i][j] = '*'
    while q:
        x, y = q.popleft()
        for dx, dy in d:
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if board[nx][ny] == 0:
                    board[nx][ny] = '*'
                    q.append((nx, ny))
                elif board[nx][ny] != '*':
                    board[nx][ny] = '*'


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    board = [list(input().rstrip()) for _ in range(n)]

    for i in range(n):
        for j in range(n):
            if board[i][j] == '.':
                count(i, j)

    ans = 0
    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                ans += 1
                check(i, j)

    for i in range(n):
        for j in range(n):
            if board[i][j] != '*':
                ans += 1

    print(f'#{case} {ans}')