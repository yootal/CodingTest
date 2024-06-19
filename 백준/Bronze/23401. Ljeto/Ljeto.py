t1 = 0
t2 = 0
dict = {}
for _ in range(int(input())):
    t,a,b = map(int,input().split())
    if 1 <= a <= 4:
        if a in dict and dict[a] + 10 >= t:
            t1 += 50
        t1 += 100
        dict[a] = t
    else:
        if a in dict and dict[a] + 10 >= t:
            t2 += 50
        t2 += 100
        dict[a] = t
print(f'{t1} {t2}')