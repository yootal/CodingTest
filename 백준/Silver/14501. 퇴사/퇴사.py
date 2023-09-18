import sys 
input = sys.stdin.readline

n = int(input())
schedule = [()]
for _ in range(n):
    schedule.append((tuple(map(int,input().split()))))

dp = [0] * (n+1)

for i in range(1,n+1):
    if i + schedule[i][0] <= n + 1:
        dp[i] = schedule[i][1]
    for j in range(1,i):
        if i >= j + schedule[j][0] and i + schedule[i][0] <= n + 1:
            dp[i] = max(dp[i], dp[j] + schedule[i][1])
        
print(max(dp))