t = int(input())
for i in range(1,t+1):
    l = list(map(int,input().split()))
    l.sort()
    
    print(f"Case #{i}: ", end="")
    if l[0] + l[1] <= l[2]:
        print("invalid!")
    
    elif l[0] == l[1] and l[1] == l[2] and l[2] == l[0]:
        print("equilateral")
    
    elif l[0] == l[1] or l[1] == l[2] or l[2] == l[0]:
        print("isosceles")
    
    else:
        print("scalene")