t = int(input())
for case in range(1, t + 1):
    n = int(input())
    matrix = [list(input().split()) for _ in range(n)]
    ans = [[0] * 3 for _ in range(n)]
    for i in range(n):
        num = ''
        for j in range(n - 1, -1, -1):
            num += matrix[j][i]
        ans[i][0] = int(num)
    for i in range(n):
        num = ''
        for j in range(n - 1, -1, -1):
            num += matrix[i][j]
        ans[-i - 1][1] = num
    for i in range(n - 1, -1, -1):
        num = ''
        for j in range(n):
            num += matrix[j][i]
        ans[-i - 1][2] = num
    print(f'#{case}')
    for row in ans:
        print(*row)
