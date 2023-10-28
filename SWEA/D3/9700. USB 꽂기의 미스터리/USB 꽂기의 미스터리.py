t = int(input())
for case in range(1, t + 1):
    p, q = map(float, input().split())
    x = (1 - p) * (1 - q)
    y = p * (1 - q) * (1 - q)
    if x < y:
        print(f'#{case} YES')
    else:
        print(f'#{case} NO')