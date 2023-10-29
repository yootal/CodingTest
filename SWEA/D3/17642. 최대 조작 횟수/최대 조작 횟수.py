t = int(input())
for case in range(1, t + 1):
    a, b = map(int, input().split())
    diff = abs(b - a)
    if diff == 0:
        print(f'#{case} 0')
    elif a > b:
        print(f'#{case} -1')
    elif diff == 1:
        print(f'#{case} -1')
    else:
        print(f'#{case} {diff // 2}')