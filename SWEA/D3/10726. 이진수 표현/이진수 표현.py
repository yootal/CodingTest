t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    ans = []
    if m == 0:
        ans.append('0')
    while m != 0:
        if m % 2:
            ans.append('1')
        else:
            ans.append('0')
        m //= 2
    ans.reverse()
    if ''.join(ans[-n:]) == '1' * n:
        print(f'#{case} ON')
    else:
        print(f'#{case} OFF')