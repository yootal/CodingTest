from sys import stdin
input = stdin.readline
mod = int(1e9)

n = int(input())
dp = [[0] * (1 << 10) for _ in range(10)]

# 처음 1 ~ 9
for i in range(1, 10):
    dp[i][1 << i] = 1

for _ in range(1, n):
    dp2 = [[0] * (1 << 10) for _ in range(10)]
    for j in range(10):
        for k in range(1 << 10):
            if j < 9:
                dp2[j][k | (1 << j)] = (dp2[j][k | (1 << j)] + dp[j + 1][k]) % mod
            if j > 0:
                dp2[j][k | (1 << j)] = (dp2[j][k | (1 << j)] + dp[j - 1][k]) % mod
    dp = dp2
    
print(sum(dp[i][(1 << 10) - 1] for i in range(10)) % mod)