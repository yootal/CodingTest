import sys 
input = sys.stdin.readline

T,W = map(int,input().split())
tree = [0]
tree.extend([int(input()) for _ in range(T)])

dp = [[0] * (W+1) for _ in range(T+1)]

for i in range(T+1):
    if tree[i] == 1:
        dp[i][0] = dp[i-1][0] + 1
    
    else:
        dp[i][0] = dp[i-1][0]
        
    for j in range(1,W+1):
        if tree[i] == 2 and j % 2 == 1:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + 1
            
        elif tree[i] == 1 and j % 2 == 0:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + 1
            
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j])
            
print(max(dp[T]))