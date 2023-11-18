import sys 
input = sys.stdin.readline

n = int(input())
num_list = [0]
dp = [0] * (n+1)

total = 0

for _ in range(n):
    num = int(input())
    num_list.append(num)
    total += num
    
if n <= 2:
    print(total)
    exit()
    
dp[1] = num_list[1]
dp[2] = num_list[2]
dp[3] = num_list[3]

for i in range(4,n):
    dp[i] = min(dp[i-2],dp[i-3]) + num_list[i]

print(total - min(dp[n-1],dp[n-2]))