t = int(input())
for case in range(1, t + 1):
    n = int(input())
    num = list(map(int, input().split()))
    ans = 0
    for i in range(1, n - 1):
        if max(num[i - 1], num[i + 1]) > num[i] > min(num[i - 1], num[i + 1]):
            ans += 1
    print(f'#{case} {ans}')