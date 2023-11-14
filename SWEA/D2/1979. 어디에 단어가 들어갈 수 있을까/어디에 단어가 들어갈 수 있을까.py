t = int(input())
for case in range(1, t + 1):
    n, k = map(int, input().split())
    board = [list(map(int, input().split())) for _ in range(n)]
    ans = 0
    for i in range(n):
        cnt = 0
        for j in range(n):
            if board[i][j] == 1:
                cnt += 1
            if board[i][j] == 0 or j == n - 1:
                if cnt == k:
                    ans += 1
                cnt = 0
        for j in range(n):
            if board[j][i] == 1:
                cnt += 1
            if board[j][i] == 0 or j == n - 1:
                if cnt == k:
                    ans += 1
                cnt = 0
    print(f'#{case} {ans}')