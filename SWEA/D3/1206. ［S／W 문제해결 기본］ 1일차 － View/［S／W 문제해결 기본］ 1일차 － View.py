for c in range(1,11):
    n = int(input())
    buildings = list(map(int,input().split()))
    
    ans = 0
    for i in range(2,n-2):
        left = max(buildings[i-2],buildings[i-1])
        right = max(buildings[i+2],buildings[i+1])
        highest = max(left,right)
        if highest >= buildings[i]:
            continue
        ans += (buildings[i] - highest)
        
    print(f"#{c} {ans}")
