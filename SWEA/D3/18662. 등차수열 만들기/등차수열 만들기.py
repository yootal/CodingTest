t = int(input())
for case in range(1, t + 1):
    a, b, c = map(int, input().split())
    ans1 = abs(2 * b - c - a)
    ans2 = abs((a + c) / 2 - b)
    ans3 = abs(2 * b - a - c)
    print(f'#{case} {min(ans1, ans2, ans3):.1f}')