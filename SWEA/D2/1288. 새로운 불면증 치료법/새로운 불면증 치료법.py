t = int(input())
for case in range(1, t + 1):
    n = int(input())
    num = n
    check = set()
    w = 1
    while len(check) != 10:
        for x in str(num):
            check.add(x)
            if len(check) == 10:
                print(f'#{case} {w * n}')
                break
        w += 1
        num = n * w