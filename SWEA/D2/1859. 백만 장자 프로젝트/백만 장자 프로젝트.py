t = int(input())
for case in range(1,t+1):
    n = int(input())
    cost = list(map(int,input().split()))
    
    max_cost = 0
    profit = 0
    
    for i in range(n-1,-1,-1):
        if cost[i] > max_cost:
            max_cost = cost[i]
        else:
            profit += (max_cost - cost[i])
    
    print(f"#{case} {profit}")