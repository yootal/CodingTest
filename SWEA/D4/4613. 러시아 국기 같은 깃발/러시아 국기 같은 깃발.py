def find_min():
    global ans
    for i in range(1, n - 2 + 1):
        for j in range(1, n - i - 1 + 1):
            total = 0
            for w in range(i):
                total += row_count[w][1] + row_count[w][2]
            for b in range(i, i + j):
                total += row_count[b][0] + row_count[b][2]
            for r in range(i + j, n):
                total += row_count[r][0] + row_count[r][1]
            ans = min(ans, total)


t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    row_count = [[0, 0, 0] for _ in range(n)]
    for i in range(n):
        inp = list(input().rstrip())
        for x in inp:
            if x == 'W':
                row_count[i][0] += 1
            elif x == 'B':
                row_count[i][1] += 1
            else:
                row_count[i][2] += 1
    ans = 1e9
    find_min()
    print(f'#{case} {ans}')
