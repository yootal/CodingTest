k, w, m = map(int, input().split())
print(int((w - k) / m) if (w - k) % m == 0 else int((w - k) / m) + 1)