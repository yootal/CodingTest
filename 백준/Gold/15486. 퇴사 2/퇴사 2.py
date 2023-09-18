import sys 
input = sys.stdin.readline

n = int(input())
schedule = [()]
for _ in range(n):
    schedule.append((tuple(map(int,input().split()))))

dp = [0] * (n+2) # i번째 일에 상담을 시작했을 때 얻을 수 있는 최대 수익

for i in range(n,0,-1):
    # i번째 일에 상담을 할 수 있을 경우
    if i + schedule[i][0] <= n + 1:
        # i번째 일에 상담을 했을 때와 상담을 하지 않았을 때 얻을 수 있는 수익 중 최대 수익을 취함
        dp[i] = max(dp[i + schedule[i][0]] + schedule[i][1], dp[i+1])
    else:
        dp[i] = dp[i+1]
              
print(max(dp))