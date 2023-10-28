t = int(input())
for case in range(1, t + 1):
    a, b = map(int, input().split())
    if a > 9 or b > 9:
        print(f'#{case} -1')
    else:
        print(f'#{case} {a * b}')