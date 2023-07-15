import sys 
input = sys.stdin.readline

inp = int(input())

dp = [[1,1,1,1,1,1,1,1,1]]
for _ in range(1,inp):
    dp.append([0 for _ in range(0,10)])

if inp == 1:
    print(sum(dp[0]))
else:
    for i in range(1,inp):
        for j in range(10):
            if i == 1:
                if j == 0:
                    dp[i][j] = dp[i-1][j]
                elif j == 1:
                    dp[i][j] = dp[i-1][j]
                elif j == 9:
                    dp[i][j] = dp[i-1][j-2]
                else:
                    dp[i][j] = dp[i-1][j-2] + dp[i-1][j]
            else:
                if j == 0:
                    dp[i][j] = dp[i-1][j+1]
                elif j == 9:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
            
    print(sum(dp[inp-1])% 1000000000)



    

            
        