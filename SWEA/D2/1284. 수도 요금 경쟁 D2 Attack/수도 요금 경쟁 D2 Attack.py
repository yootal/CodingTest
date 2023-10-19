t  = int(input())
for case in range(1,t+1):
    p,q,r,s,w = map(int,input().split())
    if w <= r:
        B_cost = q
    else:
        B_cost = q + s * (w - r)
    ans = min(p*w,B_cost)
    print(f"#{case} {ans}")
