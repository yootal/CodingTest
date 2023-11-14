case1 = {1, 3, 5, 7, 8, 10, 12}
case2 = {4, 6, 9, 11}

t = int(input())
for case in range(1, t + 1):
    num = input()
    m = int(num[4:6])
    ans = -1
    if m > 0:
        d = int(num[6:])
        if m in case1 and 1 <= d <= 31:
            ans = f'{num[:4]}/{num[4:6]}/{num[6:]}'
        elif m in case2 and 1 <= d <= 30:
            ans = f'{num[:4]}/{num[4:6]}/{num[6:]}'
        elif m == 2 and 1 <= d <= 28:
            ans = f'{num[:4]}/{num[4:6]}/{num[6:]}'

    print(f'#{case} {ans}')