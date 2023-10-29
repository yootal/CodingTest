t = int(input())
for case in range(1, t + 1):
    p = input().rstrip()
    q = input().rstrip()
    if p + 'a' == q:
        print(f'#{case} N')
    else:
        print(f'#{case} Y')

