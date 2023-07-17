import sys 
input = sys.stdin.readline

n1, n2 = map(int,input().split())
num_list = list(map(int,input().split()))
n3 = n1 - (n2-1)

dp = [0] * (n1+1)
dp[0] = num_list[0]

for i in range(1,n1):
    dp[i] = dp[i-1] + num_list[i]
    
l = []
for j in range(n3):
    if j == 0:
        l.append(dp[j+(n2-1)])
    else:
        l.append(dp[j+(n2-1)]-dp[j-1])
    
print(max(l))