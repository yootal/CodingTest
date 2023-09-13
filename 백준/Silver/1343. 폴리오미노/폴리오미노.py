import sys
input = sys.stdin.readline

board = input().rstrip()

x_cnt = 0
ans = ""
for i in range(len(board)):
    if board[i] == 'X':
        x_cnt += 1
    elif board[i] == '.':
        if x_cnt % 2 == 0:
            if x_cnt % 4 == 2:
                ans += "AAAA" * (x_cnt // 4)
                ans += "BB"
            else:
                ans += "AAAA" * (x_cnt // 4)
            x_cnt = 0
            ans += '.'
        else:
            print(-1)
            exit()
    if i == len(board) - 1:
        if x_cnt % 2 == 0:
            if x_cnt % 4 == 2:
                ans += "AAAA" * (x_cnt // 4)
                ans += "BB"
            else:
                ans += "AAAA" * (x_cnt // 4)
            x_cnt = 0
        else:
            print(-1)
            exit()
        
print(ans)