import sys 
input = sys.stdin.readline

str = input().rstrip()
n = int(input())
str_len = len(str)
dp = [[0]*26 for _ in range(str_len)]

dp[0][ord(str[0])-97] += 1 

for i in range(1,str_len):
    dp[i] = dp[i-1][:]
    dp[i][ord(str[i])-97] += 1
    
for _ in range(n):
    c,s,e = input().split()
    s = int(s)
    e = int(e)
    if s==0:
        print(dp[e][ord(c)-97])
    else:
        print(dp[e][ord(c)-97]-dp[s-1][ord(c)-97])