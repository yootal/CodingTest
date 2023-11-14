t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    if n > m:
        ans = '>'
    elif n < m:
        ans = '<'
    else:
        ans = '='
    print(f'#{case} {ans}')