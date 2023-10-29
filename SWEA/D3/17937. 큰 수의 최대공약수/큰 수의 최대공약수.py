t = int(input())
for case in range(1, t + 1):
    a, b = map(int, input().split())
    if a == b:
        print(f'#{case} {a}')
    else:
        print(f'#{case} 1')