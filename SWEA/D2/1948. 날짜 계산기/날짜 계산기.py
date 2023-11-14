day = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}

t = int(input())
for case in range(1, t + 1):
    m1, d1, m2, d2 = map(int, input().split())
    if m1 == m2:
        ans = d2 - d1 + 1
    else:
        ans = day[m1] - d1 + 1 + d2
        for x in range(m1 + 1, m2):
            ans += day[x]
    print(f'#{case} {ans}')
