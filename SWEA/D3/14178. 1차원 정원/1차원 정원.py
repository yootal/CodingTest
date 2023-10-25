t = int(input())
for case in range(1,t+1):
    n,d = map(int,input().split())
    gap = 2*d+1
    ans = -1
    for i in range(0,n+1,gap):
        ans += 1
    if n % gap != 0:
        ans += 1 
    print(f"#{case} {ans}")