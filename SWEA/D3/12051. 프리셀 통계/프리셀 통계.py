t = int(input())
for case in range(1, t + 1):
    n, d, g = map(int, input().split())
    if d != 0 and g == 0:
        print(f'#{case} Broken')
    elif d != 100 and g == 100:
        print(f'#{case} Broken')
    else:
        check = False
        for k in range(1, n + 1):
            if (k * d / 100) == (k * d // 100):
                check = True
                break
        if check:
            print(f'#{case} Possible')
        else:
            print(f'#{case} Broken')