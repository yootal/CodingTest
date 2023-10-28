t = int(input())
for case in range(1, t + 1):
    d, a, b, f = map(int, input().split())
    t = d / (a + b)
    ans = t * f
    print(f'#{case} {ans}')