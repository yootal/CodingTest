t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    matrix = [list(map(int, input().split())) for _ in range(n)]
    ans = 0
    for i in range(n - m + 1):
        for j in range(n - m + 1):
            _sum = 0
            for k in range(m):
                for l in range(m):
                    _sum += matrix[i + k][j + l]
            if _sum > ans:
                ans = _sum
    print(f'#{case} {ans}')
