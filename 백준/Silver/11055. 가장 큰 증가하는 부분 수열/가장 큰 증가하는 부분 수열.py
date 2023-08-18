import sys 
input = sys.stdin.readline

n = int(input())
num = list(map(int,input().split()))
dp = num[:]

for i in range(n):
    for j in range(i):
        if num[i] > num[j]:
            dp[i] = max(dp[i], dp[j] + num[i])

print(max(dp))
