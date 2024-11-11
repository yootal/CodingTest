m1 = [136, 142, 148, 154]
m2 = [1000, 5000, 10000, 50000]
total = 0
for _ in range(int(input())):
    a, b = map(int, input().split())
    idx = m1.index(a)
    total += m2[idx]
print(total)