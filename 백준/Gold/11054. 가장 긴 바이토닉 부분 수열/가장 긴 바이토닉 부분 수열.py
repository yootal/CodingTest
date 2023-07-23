import sys
input=sys.stdin.readline

n = int(input())
num_list = list(map(int,input().split()))

dp = [[1,0] for _ in range(n)]

for i in range(1,n):
    for i2 in range(i):
        if num_list[i] > num_list[i2]:
            dp[i][0] = max(dp[i][0], dp[i2][0]+1)

for j in range(n-1,-1,-1):
    for j2 in range(n-1,j,-1):
        if num_list[j] > num_list[j2]:
            dp[j][1] = max(dp[j][1], dp[j2][1]+1) 
    
print(max(sum(ans) for ans in dp))