from sys import stdin, maxsize
input = stdin.readline

s = input().rstrip()
n = len(s)
dp = [[maxsize] * n for _ in range(n)]

# 범위 홀수 
for idx in range(n):
    st = idx
    en = idx
    while s[st] == s[en]:
        dp[st][en] = 1
        if st - 1 >= 0 and en + 1 <= n - 1:
            st -= 1
            en += 1
        else:
            break
# 범위 짝수
for gap in range(n - 1):
    st = gap
    en = gap + 1
    while s[st] == s[en]:
        dp[st][en] = 1
        if st - 1 >= 0 and en + 1 <= n - 1:
            st -= 1
            en += 1
        else:
            break

for r in range(1, n):
    dp[0][r] = min(dp[0][r], min([dp[0][idx] + dp[idx + 1][r] for idx in range(0, r)]))
print(dp[0][n - 1])