t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    flag = True
    for _ in range(n):
        if m % 2 == 0:
            flag = False
            break
        m //= 2
    if flag:
        print(f'#{case} ON')
    else:
        print(f'#{case} OFF')