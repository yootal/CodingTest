from sys import stdin
input = stdin.readline

dp = [''] * 101
dp[2] = '1'
dp[3] = '7'
dp[4] = '4'
dp[5] = '2'
dp[6] = '6'
dp[7] = '8'
d = {2:'1',3:'7',4:'4',5:'2',6:'0',7:'8'}

for i in range(8,101):
    dp[i] = '1' * (i // 2)
    for j in range(2,8):
        if i-j == 0 or i-j == 1:
            continue
        if int(dp[i]) > int(dp[i-j] + d[j]):
            dp[i] = dp[i-j] + d[j]

t = int(input())
for _ in range(t):
    n = int(input())
    if n % 2 == 0:
        max_ans = '1' * (n // 2)
    else:
        max_ans = '7' + '1' * (n // 2 - 1)
    print(dp[n],max_ans)