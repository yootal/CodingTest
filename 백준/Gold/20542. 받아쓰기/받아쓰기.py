from sys import stdin
input = stdin.readline

n,m = map(int,input().split())
s1 = input().rstrip()
s2 = input().rstrip()

dp = [[i] + [0] * m for i in range(n+1)]
for i in range(m+1):
    dp[0][i] = i

for i in range(1,n+1):
    for j in range(1,m+1):
        if s1[i-1] == s2[j-1] or (s1[i-1] == 'v' and s2[j-1] == 'w') or (s1[i-1] == 'i' and s2[j-1] in ('j','l')):
            dp[i][j] = dp[i-1][j-1]
        else:
            dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]) + 1

print(dp[n][m]) 