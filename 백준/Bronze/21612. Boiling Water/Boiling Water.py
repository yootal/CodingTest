b = int(input())
p = 5 * b - 400
print(p)
print((100 - p) // abs(100 - p) if p != 100 else 0)