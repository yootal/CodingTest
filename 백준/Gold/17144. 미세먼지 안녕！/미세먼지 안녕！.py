from sys import stdin
from collections import defaultdict
from copy import deepcopy
input = stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

R,C,T = map(int,input().split())
air_cleaner = []
board = []
for r in range(R):
    inp = list(map(int,input().split()))
    if inp[0] == -1:
        air_cleaner.append(r)
        inp[0] = 0
    board.append(inp)

for _ in range(T):
    
    # 확산
    # temp_board = [[0] * C for _ in range(R)]
    temp_board = deepcopy(board)
    for i in range(R):
        for j in range(C):
            if board[i][j] > 0:
                cnt = 0
                for dx,dy in d:
                    nx = i + dx
                    ny = j + dy
                    if (nx == air_cleaner[0] and ny == 0) or (nx == air_cleaner[1] and ny == 0):
                        continue
                    if 0 <= nx < R and 0 <= ny < C:
                        cnt += 1
                        temp_board[nx][ny] += int(board[i][j] / 5)
                temp_board[i][j] -= (int(board[i][j] / 5) * cnt)
                
    # print()
    # for row in temp_board:
    #     print(*row)
    
    #  순환
    # temp_board2 = [[0] * C for _ in range(R)]
    temp_board2 = deepcopy(temp_board)
    for i1 in range(1,C):
        temp_board2[air_cleaner[0]][i1] = temp_board[air_cleaner[0]][i1-1]
    for j1 in range(air_cleaner[0]-1,-1,-1):
        temp_board2[j1][C-1] = temp_board[j1+1][C-1]
    for i2 in range(C-2,-1,-1):
        temp_board2[0][i2] = temp_board[0][i2+1]
    for j2 in range(1,air_cleaner[0]+1):
        temp_board2[j2][0] = temp_board[j2-1][0]
    
    for i3 in range(1,C):
        temp_board2[air_cleaner[1]][i3] = temp_board[air_cleaner[1]][i3-1]
    for j3 in range(air_cleaner[1]+1,R):
        temp_board2[j3][C-1] = temp_board[j3-1][C-1]
    for i4 in range(C-2,-1,-1):
        temp_board2[R-1][i4] = temp_board[R-1][i4+1]
    for j4 in range(R-2,air_cleaner[1]-1,-1):
        temp_board2[j4][0] = temp_board[j4+1][0]
    
    # for i in range(1,air_cleaner[0]):
    #     for j in range(1,C-1):
    #         temp_board2[i][j] = temp_board[i][j]
    
    # for i in range(air_cleaner[1]+1,R-1):
    #     for j in range(1,C-1):
    #         temp_board2[i][j] = temp_board[i][j]
    
    temp_board2[air_cleaner[0]][0] = 0
    temp_board2[air_cleaner[1]][0] = 0
        
    board = temp_board2

# print()
# for row in board:
#     print(*row)
print(sum([sum(row) for row in board]))
            