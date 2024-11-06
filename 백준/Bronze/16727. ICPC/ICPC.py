a, b = map(int, input().split())
c, d = map(int, input().split())
p = a + d
s = b + c
if p == s:
    if a == c:
        print("Penalty")
    elif a > c:
        print("Esteghlal")
    else:
        print("Persepolis")
elif p > s:
    print("Persepolis")
else:
    print("Esteghlal")