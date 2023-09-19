import sys 
input = sys.stdin.readline

N = int(input())
dp = [0,1]
for i in range(2, abs(N) + 1):
    dp.append((dp[i-1] + dp[i-2]) % 1000000000)
    
if N % 2 == 0 and N < 0:
    print(-1)
elif N == 0:
    print(0)
else:
    print(1)
    
print(dp[abs(N)])