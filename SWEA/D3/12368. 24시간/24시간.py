t = int(input())
for case in range(1, t + 1):
    a, b = map(int, input().split())
    ans = a + b
    while ans >= 24:
        ans -= 24
    print(f'#{case} {ans}')