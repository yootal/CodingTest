t  = int(input())
for case in range(1,t+1):
    n = int(input())
    total = 0
    
    for i in range(1,n+1):
        if i % 2 == 0:
            total -= i
        else:
            total += i
        
    print(f"#{case} {total}")
