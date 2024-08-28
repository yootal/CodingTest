x, l, r = map(int, input().split())
if l <= x <= r:
    print(x)
else:
    print(l if abs(x - l) < abs(x - r) else r)