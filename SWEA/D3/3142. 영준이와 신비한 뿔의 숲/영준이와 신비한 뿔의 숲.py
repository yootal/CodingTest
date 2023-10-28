t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    two = n - m
    one = m - two
    print(f'#{case} {one} {two}')