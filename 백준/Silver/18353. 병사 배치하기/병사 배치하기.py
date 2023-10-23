from sys import stdin
input = stdin.readline

n = int(input())
score = list(map(int,input().split()))
dp = [1] * (n)
for i in range(n):
    for j in range(i):
        if score[i] < score[j]:
            dp[i] = max(dp[i],dp[j] + 1)
            
print(n-max(dp))