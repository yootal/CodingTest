import sys
input = sys.stdin.readline

code = [0] + list(map(int,list(input().rstrip())))
n = len(code) - 1
dp = [0] * (n+1)
dp[0] = 1

if code[1] == 0:
    print(0)
    
else:
    for i in range(1,n+1):
        if code[i] > 0:
            dp[i] += dp[i-1]
        if 10 <= code[i-1] * 10 + code[i] <= 26:
            dp[i] += dp[i-2]

    print(dp[n] % 1000000)