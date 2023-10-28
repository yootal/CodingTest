t = int(input())
for case in range(1, t + 1):
    n, a, b = map(int, input().split())
    _max = min(a, b)
    _min = (a + b) - n
    if _min < 0:
        _min = 0
    print(f'#{case} {_max} {_min}')
