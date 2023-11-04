t = int(input())
for case in range(1, t + 1):
    n = int(input())
    while n > 3:
        n = n // 2 + 1
        n = n // 2 - 1
    if n >= 2 or n == 0:
        print(f'#{case} Alice')
    else:
        print(f'#{case} Bob')