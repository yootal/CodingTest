from sys import stdin
input = stdin.readline

n = int(input())
max_dp = [[0] * 3 for _ in range(2)]
min_dp = [[0] * 3 for _ in range(2)]

for i in range(1,n+1):
    inp = list(map(int,input().split()))
    max_dp[i%2][0] = max(max_dp[(i-1)%2][0],max_dp[(i-1)%2][1]) + inp[0]
    max_dp[i%2][1] = max(max_dp[(i-1)%2][0],max_dp[(i-1)%2][1],max_dp[(i-1)%2][2]) + inp[1]
    max_dp[i%2][2] = max(max_dp[(i-1)%2][1],max_dp[(i-1)%2][2]) + inp[2]
    min_dp[i%2][0] = min(min_dp[(i-1)%2][0],min_dp[(i-1)%2][1]) + inp[0]
    min_dp[i%2][1] = min(min_dp[(i-1)%2][0],min_dp[(i-1)%2][1],min_dp[(i-1)%2][2]) + inp[1]
    min_dp[i%2][2] = min(min_dp[(i-1)%2][1],min_dp[(i-1)%2][2]) + inp[2]
    
print(max(max_dp[n%2]),min(min_dp[n%2]))