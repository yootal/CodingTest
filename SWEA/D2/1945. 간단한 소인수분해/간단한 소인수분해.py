t = int(input())
for case in range(1, t + 1):
    n = int(input())
    cnt = [0] * 5
    m = (2, 3, 5, 7, 11)
    while n != 1:
        for i in range(5):
            if n % m[i] == 0:
                n //= m[i]
                cnt[i] += 1
                break
    print(f'#{case}', end=' ')
    print(*cnt)
