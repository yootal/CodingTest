t = int(input())
for case in range(1, t + 1):
    n = int(input())
    if n == 1:
        print(f'#{case} 9 8')
    else:
        print(f'#{case} {n * 3} {n * 2}')