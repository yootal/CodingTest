l = []
for _ in range(int(input())):
    l.append(list(input().split()))
    
u = set()
    
for l1 in l:
    if l1[1] == "enter":
        u.add(l1[0])
    elif l1[1] == "leave":
        u.discard(l1[0])

r = sorted(list(u),reverse=True)

for r1 in r:
    print(r1)