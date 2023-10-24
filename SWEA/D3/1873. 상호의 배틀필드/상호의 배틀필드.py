def find():
    for i in range(n):
        for j in range(m):
            if board[i][j] == '<': 
                return ['L',i,j]
            if board[i][j] == '>': 
                return ['R',i,j]
            if board[i][j] == '^':
                return ['U',i,j] 
            if board[i][j] == 'v':
                return ['D',i,j]                
                        
t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    board = [list(input().rstrip()) for _ in range(n)]
    cur = find()
    command_len = int(input())
    command = list(input().rstrip())
    for c in command:
        if c == 'S':
            if cur[0] == 'U':
                x,y = cur[1],cur[2]
                nx = x
                while True:
                    nx -= 1
                    if nx < 0:
                        break
                    elif board[nx][y] == '*':
                        board[nx][y] = '.'
                        break
                    elif board[nx][y] == '#':
                        break
            elif cur[0] == 'D':
                x,y = cur[1],cur[2]
                nx = x
                while True:
                    nx += 1
                    if nx > n-1:
                        break
                    elif board[nx][y] == '*':
                        board[nx][y] = '.'
                        break
                    elif board[nx][y] == '#':
                        break
            elif cur[0] == 'L':
                x,y = cur[1],cur[2]
                ny = y
                while True:
                    ny -= 1
                    if ny < 0:
                        break
                    elif board[x][ny] == '*':
                        board[x][ny] = '.'
                        break
                    elif board[x][ny] == '#':
                        break
            elif cur[0] == 'R':
                x,y = cur[1],cur[2]
                ny = y
                while True:
                    ny += 1
                    if ny > m-1:
                        break
                    elif board[x][ny] == '*':
                        board[x][ny] = '.'
                        break
                    elif board[x][ny] == '#':
                        break
        elif c == 'U':
            cur[0] = 'U'
            if cur[1] - 1 < 0 or board[cur[1]-1][cur[2]] == '-' or board[cur[1]-1][cur[2]] == '*' or board[cur[1]-1][cur[2]] == '#':
                board[cur[1]][cur[2]] = '^'
                continue
            if board[cur[1]-1][cur[2]] == '.':
                board[cur[1]][cur[2]] = '.'
                board[cur[1]-1][cur[2]] = '^'
                cur[1] -= 1
        elif c == 'D':
            cur[0] = 'D'
            if cur[1] + 1 > n-1 or board[cur[1]+1][cur[2]] == '-' or board[cur[1]+1][cur[2]] == '*' or board[cur[1]+1][cur[2]] == '#':
                board[cur[1]][cur[2]] = 'v'
                continue
            if board[cur[1]+1][cur[2]] == '.':
                board[cur[1]][cur[2]] = '.'
                board[cur[1]+1][cur[2]] = 'v'
                cur[1] += 1
        elif c == 'L':
            cur[0] = 'L'
            if cur[2] - 1 < 0 or board[cur[1]][cur[2]-1] == '-' or board[cur[1]][cur[2]-1] == '*' or board[cur[1]][cur[2]-1] == '#':
                board[cur[1]][cur[2]] = '<'
                continue
            if board[cur[1]][cur[2]-1] == '.':
                board[cur[1]][cur[2]] = '.'
                board[cur[1]][cur[2]-1] = '<'
                cur[2] -= 1
        elif c == 'R':
            cur[0] = 'R'
            if cur[2] + 1 > m-1 or board[cur[1]][cur[2]+1] == '-' or board[cur[1]][cur[2]+1] == '*' or board[cur[1]][cur[2]+1] == '#':
                board[cur[1]][cur[2]] = '>'
                continue
            if board[cur[1]][cur[2]+1] == '.':
                board[cur[1]][cur[2]] = '.'
                board[cur[1]][cur[2]+1] = '>'
                cur[2] += 1
    print(f"#{case}",end=" ")
    for row in board:
        print(''.join(row))