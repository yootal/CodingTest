x1, x2 = map(int, input().split())
a = 100 - x1
b = 100 - x2
c = 100 - (a + b)
d = a * b
q = d // 100
r = d % 100
print(f'{a} {b} {c} {d} {q} {r}')
print(f'{c + q} {r}')