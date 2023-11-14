d = [(0, 1), (1, 0), (0, -1), (-1, 0)]


def dfs(x, y, st, dir):
    while 0 <= x < n and 0 <= y < n and matrix[x][y] == 0:
        matrix[x][y] = st
        st += 1
        x += d[dir][0]
        y += d[dir][1]
        if st == n ** 2 + 1:
            return
    x = x - d[dir][0] + d[(dir + 1) % 4][0]
    y = y - d[dir][1] + d[(dir + 1) % 4][1]
    dfs(x, y, st, (dir + 1) % 4)


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    matrix = [[0 for _ in range(n)] for _ in range(n)]
    dfs(0, 0, 1, 0)
    print(f'#{case}')
    for row in matrix:
        print(*row)
