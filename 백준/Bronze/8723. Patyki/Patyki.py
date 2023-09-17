l = list(map(int,input().split()))
l.sort()
if l[0] == l[1] == l[2]:
    print(2)
elif l[0] ** 2 + l[1] ** 2 == l[2] ** 2:
    print(1)
else:
    print(0)