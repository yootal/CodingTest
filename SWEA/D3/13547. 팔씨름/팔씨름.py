t = int(input())
for case in range(1, t + 1):
    s = list(input())
    n = len(s)
    win = 0
    lose = 0
    for i in range(n):
        if s[i] == 'o':
            win += 1
        else:
            lose += 1
    if lose <= 7 or win + (15 - n) >= 8:
        print(f'#{case} YES')
    else:
        print(f'#{case} NO')