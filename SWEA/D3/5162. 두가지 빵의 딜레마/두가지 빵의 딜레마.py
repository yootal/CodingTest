t = int(input())
for case in range(1, t + 1):
    a, b, c = map(int, input().split())
    _min = min(a, b)
    print(f'#{case} {c // _min}')