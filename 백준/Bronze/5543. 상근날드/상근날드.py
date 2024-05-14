a, b = 2000, 2000
for _ in range(3):
    a = min(a, int(input()))
for _ in range(2):
    b = min(b, int(input()))
print(a + b - 50)