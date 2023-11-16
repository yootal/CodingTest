t = int(input())
for case in range(1, t + 1):
    n = int(input())
    num = list(map(int, input().split()))
    for i in range(1, n):
        if num[i - 1] + num[i] > num[i]:
            num[i] = num[i - 1] + num[i]
    print(f'#{case} {max(num)}')