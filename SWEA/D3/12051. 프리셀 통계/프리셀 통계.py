t = int(input())
for case in range(1, t + 1):
    n, pd, pg = map(int, input().split())
    if pg == 0 and pd != 0:
        print(f'#{case} Broken')
    elif pg == 100 and pd != 100:
        print(f'#{case} Broken')
    else:
        for i in range(1, n + 1):
            if i * pd / 100 == i * pd // 100:
                print(f'#{case} Possible')
                break
        else:
            print(f'#{case} Broken')
