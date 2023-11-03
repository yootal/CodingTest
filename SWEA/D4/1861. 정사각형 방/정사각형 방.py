def dfs(x, y, v, cnt):
    global count
    count[v] = cnt
    for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        nx = x + dx
        ny = y + dy
        if 0 <= nx < n and 0 <= ny < n:
            if board[nx][ny] == board[x][y] + 1:
                dfs(nx, ny, v, cnt + 1)


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    board = [list(map(int, input().split())) for _ in range(n)]
    count = [0] * (n ** 2 + 1)
    for i in range(n):
        for j in range(n):
            dfs(i, j, board[i][j], 1)
    max_count = max(count)
    room_idx = count.index(max_count)
    print(f'#{case} {room_idx} {max_count}')