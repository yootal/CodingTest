t = int(input())
for case in range(1, t + 1):
    n, a, b = map(int, input().split())
    ans = a * (n - 1)
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if i * j > n:
                break
            ans = min(ans, a * abs(i - j) + b * (n - i * j))
    print(f'#{case} {ans}')