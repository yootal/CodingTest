import sys
input=sys.stdin.readline

n = int(input())
line = []

dp = [1] * n

for _ in range(n):
    line.append(list(map(int,input().split())))
    
line.sort(key= lambda x: x[0])
for i in range(1,n):
    for j in range(i):
        if line[i][0] > line[j][0] and line[i][1] > line[j][1]:
            dp[i] = max(dp[i],dp[j]+1)
            
print(n-max(dp))
