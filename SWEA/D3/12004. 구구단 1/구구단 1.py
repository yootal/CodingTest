t = int(input())
for case in range(1, t + 1):
    n = int(input())
    for i in range(1, 10):
        a = n // i
        if 1 <= a <= 9 and a * i == n:
            break
    else:
        print(f'#{case} No')
        continue
    print(f'#{case} Yes')
