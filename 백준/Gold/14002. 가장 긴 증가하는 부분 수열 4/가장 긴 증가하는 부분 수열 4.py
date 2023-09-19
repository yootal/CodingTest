import sys
input = sys.stdin.readline

n = int(input())
num = [0] + list(map(int,input().split()))
pre = [0] * (n+1)
dp = [0] + [1] * (n)

for i in range(1,n+1):
    for j in range(1,i):
        if num[i] > num[j]:
            if dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1
                pre[i] = j
                
print(max(dp))
k = dp.index(max(dp))
ans = []
while k != 0:
    ans.append(num[k])
    k = pre[k]
print(*(reversed(ans)))
