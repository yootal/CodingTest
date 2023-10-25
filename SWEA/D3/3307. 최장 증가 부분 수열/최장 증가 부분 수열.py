t = int(input())
for case in range(1,t+1):
    n = int(input())
    num = [0] + list(map(int,input().split()))
    dp = [0] * (n+1)
    for i in range(1,n+1):
        for j in range(i):
            if num[j] < num[i]:
                dp[i] = max(dp[i],dp[j] + 1)
    print(f"#{case} {max(dp)}")