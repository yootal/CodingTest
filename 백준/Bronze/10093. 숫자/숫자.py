a = list(map(int,input().split()))
a.sort()
if a[0] == a[1]:
    print(0)
else: 
    print(a[1]-a[0]-1)
    for c in range(a[0]+1,a[1]):
        print(c,end=" ")