t = int(input())
for case in range(1, t + 1):
    n = int(input())
    v = 0
    ans = 0
    for _ in range(n):
        c = list(map(int, input().split()))
        if c[0] == 1:
            v += c[1]
        elif c[0] == 2:
            v -= c[1]
            if v < 0:
                v = 0
        ans += v
    print(f'#{case} {ans}')
