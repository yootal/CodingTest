last = [31,28,31,30,31,30,31,31,30,31,30,31]
t  = int(input())
for case in range(1,t+1):
    a1,a2,b1,b2 = map(int,input().split())
    
    ans = 0
    if a1 == b1:
        ans = b2 - a2 + 1
    else:
        ans += last[a1-1] - a2 + 1
        for i in range(a1,b1-1):
            ans += last[i]
        ans += b2
        
    print(f"#{case} {ans}")