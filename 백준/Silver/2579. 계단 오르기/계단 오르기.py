import sys 
input = sys.stdin.readline

inp = int(input())

dp = [0 for _ in range(inp)]
number_list = []

for _ in range(inp):
    number_list.append(int(input()))

if inp <= 2: 
    print(sum(number_list))

else:
    dp[0] = number_list[0]
    dp[1] = number_list[0] + number_list[1]
    
    for i in range(2,inp):
        dp[i] = max(dp[i-3] + number_list[i-1] + number_list[i], dp[i-2] + number_list[i])
    
    print(dp[inp-1])