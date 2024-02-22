s1 = 100
s2 = 100
for _ in range(int(input())):
    a, b = map(int,input().split())
    if a > b:
        s2 -= a
    elif b > a:
        s1 -= b
print(s1)
print(s2)