import sys 
input = sys.stdin.readline

n1, n2 = map(int,input().split())
num_list = list(map(int,input().split()))

dp = [0] * n1 
dp[0] = num_list[0]
for i in range(1,n1):
    dp[i] = dp[i-1] + num_list[i]
    
for _ in range(n2):
    a,b = map(int,input().split())
    if a == b:
        print(num_list[a-1])
    elif a == 1:
        print(dp[b-1])
    else:
        print(dp[b-1]-dp[a-2])