import sys 
input = sys.stdin.readline

N = int(input())
S=[[0,0]]
S.extend(list(map(int,input().split())) for _ in range(N))
dp = [item[1] for item in S]
# 1 ~ N 
for i in range(1,N+1):
    if i + S[i][0] - 1 > N:
        dp[i] = 0
    else:
        for j in range(1,i):
            if j + S[j][0] <= i:
                dp[i] = max(dp[i], dp[j] + S[i][1])
print(max(dp))