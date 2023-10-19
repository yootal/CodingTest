t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    board = [list(map(int,input().split())) for _ in range(n)]
    prefix_sum = [[0] * (n+1) for _ in range(n+1)]
    
    for i in range(1,n+1):
        for j in range(1,n+1):
            prefix_sum[i][j] = board[i-1][j-1]
    
    for i in range(1,n+1):
        for j in range(1,n+1):
            prefix_sum[i][j] = prefix_sum[i-1][j] + prefix_sum[i][j-1] - prefix_sum[i-1][j-1] + board[i-1][j-1]
    
    ans = 0
    for i in range(m,n+1):
        for j in range(m,n+1):
            ans = max(ans,prefix_sum[i][j]-prefix_sum[i-m][j]-prefix_sum[i][j-m]+prefix_sum[i-m][j-m])
    
    print(f"#{case} {ans}")