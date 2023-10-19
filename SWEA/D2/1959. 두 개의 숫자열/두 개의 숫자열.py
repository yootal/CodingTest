t  = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    l1 = list(map(int,input().split()))
    l2 = list(map(int,input().split()))
    
    ans = 0
    if n < m:
        for i in range(m-n+1):
            total = 0
            for j in range(n):
                total += l1[j] * l2[i+j]
            ans = max(ans,total)
    else:
        for i in range(n-m+1):
            total = 0
            for j in range(m):
                total += l2[j] * l1[i+j]
            ans = max(ans,total)
            
    print(f"#{case} {ans}")