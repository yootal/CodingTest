t = int(input())
for case in range(1, t + 1):
    n = int(input())
    ans = [[1]]
    for i in range(2, n + 1):
        row = [0] * i
        for j in range(i):
            if j == 0 or j == i - 1:
                row[j] = ans[i - 2][0]
            else:
                row[j] = ans[i - 2][j - 1] + ans[i - 2][j]
        ans.append(row)
    print(f'#{case}')
    for r in ans:
        print(*r)