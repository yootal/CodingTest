t = int(input())
for case in range(1, t + 1):
    n = int(input())
    if n % 2 == 0:
        print(f'#{case} {(1 + n) * (n // 2)} {2 * n * (n // 2)} {2 * (n + 1) * (n // 2)}')
    else:
        print(f'#{case} {(1 + n) * (n // 2) + (n // 2 + 1)} {2 * n * (n // 2) + n} {2 * (n + 1) * (n // 2) + (n // 2 + 1) * 2}')