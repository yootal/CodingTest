t = int(input())
for case in range(1, t + 1):
    a, b = map(int, input().split())
    if abs(a - b) == 1 or a > b:
        print(f'#{case} -1')
    else:
        print(f'#{case} {abs(a - b) // 2}')