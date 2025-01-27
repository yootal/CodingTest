a, b = map(int, input().split())
print(0 if (a - a * 0.01 * b) >= 100 else 1)