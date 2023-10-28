t = int(input())
for case in range(1, t + 1):
    n = int(input())
    ans = 0
    d = 0
    for _ in range(n):
        p, x = map(float, input().split())
        d += p
        ans += p * x
    print(f'#{case} {ans / d}')
