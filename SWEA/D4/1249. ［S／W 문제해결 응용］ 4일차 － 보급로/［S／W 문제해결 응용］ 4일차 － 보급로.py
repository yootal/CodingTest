from collections import deque


def bfs():
    global ans
    dq = deque()
    dq.append((0, 0))
    time[0][0] = 0
    while dq:
        x, y = dq.popleft()
        if x == n - 1 and y == n - 1:
            ans.append(time[x][y])
            continue
        for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nx = x + dx
            ny = y + dy
            if 0 <= nx < n and 0 <= ny < n:
                if time[nx][ny] == -1 or time[nx][ny] > time[x][y] + board[nx][ny]:
                    time[nx][ny] = time[x][y] + board[nx][ny]
                    dq.append((nx, ny))


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    board = [list(map(int, input())) for _ in range(n)]
    time = [[-1] * n for _ in range(n)]
    ans = []
    bfs()
    print(f'#{case} {min(ans)}')