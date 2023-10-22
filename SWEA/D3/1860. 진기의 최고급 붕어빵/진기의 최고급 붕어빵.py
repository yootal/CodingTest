t = int(input())
for case in range(1,t+1):
    n,m,k = map(int,input().split())    
    arrive = list(map(int,input().split()))
    arrive.sort()
    flag = True
    for cur in range(n):
        if (arrive[cur] // m) * k - cur <= 0:
            flag = False
            break 
    if flag:
        print(f"#{case} Possible")
    else:
        print(f"#{case} Impossible")