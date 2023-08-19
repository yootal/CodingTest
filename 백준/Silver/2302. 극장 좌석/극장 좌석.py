import sys 
input = sys.stdin.readline

N = int(input())
M = int(input())
vip = [int(input()) for _ in range(M)]

dp = [0] * (41)
dp[0] = 1
dp[1] = 1
dp[2] = 2

for i in range(3,41):
    dp[i] = dp[i-1] + dp[i-2] 
               
ans = 1
if M > 0:
    pre = 0
    for j in range(M):
        ans *= dp[vip[j] - 1 - pre]
        pre = vip[j]
    ans *= dp[N-pre]
else:
    ans = dp[N]
print(ans)
