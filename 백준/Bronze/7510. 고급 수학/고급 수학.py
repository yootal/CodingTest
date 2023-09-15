t = int(input())
for i in range(1,t+1):
    l = list(map(int,input().split()))
    l.sort()
    print(f"Scenario #{i}:")
    print("yes" if l[0]**2 + l[1]**2 == l[2]**2 else "no")
    print()
    