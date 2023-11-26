from sys import stdin
from collections import defaultdict
input = stdin.readline

R,C,M = map(int,input().split())
shark_info = defaultdict(list)
board = [[0] * (C) for _ in range(R)]

for i in range(1,M+1):
    r,c,s,d,z = map(int,input().split())
    board[r-1][c-1] = i
    if r-1 == R-1 and d == 2:
        d = 1
    elif r-1 == 0 and d == 1:
        d = 2
    elif c-1 == 0 and d == 4:
        d = 3
    elif c-1 == C-1 and d == 3:
        d = 4
    shark_info[i] = [r-1,c-1,s,d,z]

ans = 0
for i in range(C):
    
    # 상어 잡기
    for j in range(R):
        if board[j][i] != 0:
            ans += shark_info[board[j][i]][4]
            shark_info.pop(board[j][i])
            board[j][i] = 0
            break

    # 새 보드
    new_board = [[0] * C for _ in range(R)]
    
    # 상어 이동
    pop_shark = []
    for num in shark_info.keys():
        if shark_info[num][3] == 1 or shark_info[num][3] == 2:
            for _ in range(shark_info[num][2] % ((R-1) * 2)):
                if shark_info[num][3] == 1:
                    shark_info[num][0] -= 1
                    if shark_info[num][0] == 0:
                        shark_info[num][3] = 2
                else:
                    shark_info[num][0] += 1
                    if shark_info[num][0] == R-1:
                        shark_info[num][3] = 1
        else:
            for _ in range(shark_info[num][2] % ((C-1) * 2)):
                if shark_info[num][3] == 3:
                    shark_info[num][1] += 1
                    if shark_info[num][1] == C-1:
                        shark_info[num][3] = 4
                else:
                    shark_info[num][1] -= 1
                    if shark_info[num][1] == 0:
                        shark_info[num][3] = 3

        if not new_board[shark_info[num][0]][shark_info[num][1]]:
            new_board[shark_info[num][0]][shark_info[num][1]] = num
        else:
            if shark_info[num][4] > shark_info[new_board[shark_info[num][0]][shark_info[num][1]]][4]:
                pop_shark.append(new_board[shark_info[num][0]][shark_info[num][1]])
                new_board[shark_info[num][0]][shark_info[num][1]] = num
            else:
                pop_shark.append(num)
    
    # 보드 갱신            
    board = new_board
    
    # 먹힌 상어
    for k in pop_shark:
        shark_info.pop(k)
        
print(ans)