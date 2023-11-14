d = [(0, 1), (1, 0), (0, -1), (-1, 0)]

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    matrix = [[0 for _ in range(n)] for _ in range(n)]
    r, c = 0, 0
    dist = 0
    for x in range(1, n * n + 1):
        matrix[r][c] = x
        r += d[dist][0]
        c += d[dist][1]
        if r < 0 or r >= n or c < 0 or c >= n or matrix[r][c] != 0:
            r -= d[dist][0]
            c -= d[dist][1]
            dist = (dist + 1) % 4
            r += d[dist][0]
            c += d[dist][1]
    print(f'#{case}')
    for row in matrix:
        print(*row)