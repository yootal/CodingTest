t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    for i in range(m + 1):
        if i + 2 * (m - i) == n:
            print(f'#{case} {i} {m - i}')
            break
