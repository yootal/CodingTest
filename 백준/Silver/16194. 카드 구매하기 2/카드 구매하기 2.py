from sys import stdin, maxsize
input = stdin.readline

n = int(input())
cards = [0] + list(map(int,input().split()))
dp = [maxsize] * (n+1)
dp[0] = 0

for i in range(n+1):
    for j in range(i+1):
        dp[i] = min(dp[i], dp[i-j] + cards[j])

print(dp[n])
    