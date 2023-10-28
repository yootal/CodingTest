t = int(input())
for case in range(1, t + 1):
    d, l, n = map(float, input().split())
    ans = 0
    for i in range(int(n)):
        ans += d * (1 + i * l * 0.01)
    print(f'#{case} {int(ans)}')
