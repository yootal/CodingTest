import math

n, a, b, c, d = map(int, input().split())
cnt1 = n / a
cnt2 = n / c
print(min(math.ceil(cnt1) * b, math.ceil(cnt2) * d))