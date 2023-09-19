import sys 
input = sys.stdin.readline

case = 0
while True:
    case += 1
    n = int(input())
    if n == 0:
        exit()
    
    dp = [[0,0,0] for _ in range(n+1)]
    board = [[]]
    for _ in range(n):
        board.append(list(map(int,input().split())))

    dp[2][0] = board[1][1] + board[2][0]
    dp[2][1] = min(dp[2][0], board[1][1], board[1][1] + board[1][2]) + board[2][1]
    dp[2][2] = min(dp[2][1], board[1][1], board[1][1] + board[1][2]) + board[2][2]

    for i in range(3,n+1):
        dp[i][0] = min(dp[i-1][0], dp[i-1][1]) + board[i][0]    
        dp[i][1] = min(dp[i-1][0], dp[i-1][1], dp[i-1][2], dp[i][0]) + board[i][1]    
        dp[i][2] = min(dp[i-1][1], dp[i-1][2], dp[i][1]) + board[i][2]    

    print(f"{case}. {dp[n][1]}")