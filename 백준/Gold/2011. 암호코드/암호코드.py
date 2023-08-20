import sys
input=sys.stdin.readline

inp = input().rstrip()
l = len(inp)
dp = [[0,0] for _ in range(l)]
dp[0] = [1,0]

if inp[0] == '0':
    print(0)
    exit()
    
for i in range(1,l):
    if int(inp[i-1]) * 10 + int(inp[i]) <= 26:
        if inp[i-1] == '0':
            if inp[i] == '0':
                print(0)
                exit()
            dp[i][0] = dp[i-1][0]
        elif inp[i] == '0':
            dp[i][0] = dp[i-1][0] 
        else:
            dp[i][0] = sum(dp[i-1]) 
            dp[i][1] = dp[i-1][0] 
    else:
        if inp[i] == '0':
            print(0)
            exit()
        else:
            dp[i][0] = sum(dp[i-1]) 
        
print(sum(dp[l-1]) % 1000000)