t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    m = list(map(int, bin(m)[2:]))
    if m[-n:].count(1) == n:
        print(f'#{case} ON')
    else:
        print(f'#{case} OFF')