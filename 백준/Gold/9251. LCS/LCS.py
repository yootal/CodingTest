import sys
input=sys.stdin.readline

a = input().rstrip()
b = input().rstrip()
len_a = len(a)
len_b = len(b)
dp = [0] * len_b

for i in range(len_a):
    check = 0
    for j in range(len_b):
        if check < dp[j]:
            check = dp[j]
        elif a[i] == b[j]:
            dp[j] = check + 1
            
print(max(dp))