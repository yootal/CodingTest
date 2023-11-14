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
            else:
                if cnt == k:
                    ans += 1
                cnt = 0
        if cnt == k:
            ans += 1
    for i in range(n):
        cnt = 0
        for j in range(n):
            if board[j][i] == 1:
                cnt += 1
            else:
                if cnt == k:
                    ans += 1
                cnt = 0
        if cnt == k:
            ans += 1
    print(f'#{case} {ans}')
