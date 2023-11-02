def dfs(x, y, depth, arr):
    global ans
    if depth == 7:
        ans.add(arr)
        return
    for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        nx = x + dx
        ny = y + dy
        if 0 <= nx < 4 and 0 <= ny < 4:
            dfs(nx, ny, depth + 1, arr + board[nx][ny])


t = int(input())
for case in range(1, t + 1):
    ans = set()
    board = [list(input().split()) for _ in range(4)]
    for i in range(4):
        for j in range(4):
            dfs(i, j, 1, f'{board[i][j]}')
    print(f'#{case} {len(ans)}')