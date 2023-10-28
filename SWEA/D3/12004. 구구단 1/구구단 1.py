t = int(input())
for case in range(1, t + 1):
    n = int(input())
    flag = False
    for i in range(1, 10):
        a = int(n / i)
        if 1 <= a <= 9 and a * i == n:
            flag = True
            break
    if flag:
        print(f'#{case} Yes')
    else:
        print(f'#{case} No')