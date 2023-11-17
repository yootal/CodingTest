t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    for _ in range(n):
        if m % 2 != 1:
            print(f'#{case} OFF')
            break
        m //= 2
    else:
        print(f'#{case} ON')
