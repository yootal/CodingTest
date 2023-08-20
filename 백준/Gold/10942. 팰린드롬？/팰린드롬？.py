import sys
input=sys.stdin.readline

n = int(input())
num = list(map(int,input().split()))
m = int(input())

dp = [[0] * n for _ in range(n)]

for dis in range(n):
    for start in range(n-dis):
        end = start + dis
        
        if start == end:
            dp[start][end] = 1
        elif num[start] == num[end]:
            if start + 1 == end:
                dp[start][end] = 1
            elif dp[start+1][end-1] == 1:
                dp[start][end] = 1

se = [tuple(map(int,input().split())) for _ in range(m)]
for s,e in se:
    print(dp[s-1][e-1])
        