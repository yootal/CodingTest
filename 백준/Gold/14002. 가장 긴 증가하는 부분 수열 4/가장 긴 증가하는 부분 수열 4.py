import sys 
input = sys.stdin.readline

N = int(input())
A = [0]
A.extend(list(map(int,input().split())))

dp = [1] * (N+1)
pre = [0] * (N+1)

for i in range(1,N+1):
    for j in range(1,i):
        if A[j] < A[i]:
            if dp[i] < dp[j] + 1:
                dp[i] = dp[j] + 1
                pre[i] = j

M=max(dp)
idx = dp.index(M)

print(M)
if idx == 0:
    print(A[1])
else:
    ans = []
    while idx != 0:
        ans.append(A[idx])
        idx = pre[idx]
    while ans:
        print(ans.pop(), end = " ")