t = int(input())
for case in range(1, t + 1):
    p, q, r, s, w = map(int, input().split())
    price1 = p * w
    price2 = q
    if r < w:
        price2 += (w - r) * s
    ans = min(price1, price2)
    print(f"#{case} {ans}")
