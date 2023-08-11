import sys
input = sys.stdin.readline

N,L = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(N)]

# 행기준
def check_row():
    slope = [[False] * N for _ in range(N)]
    row_count = 0
    for i in range(N):
        prev = board[i][0] # 이전 숫자
        same_count = 1
        flag = True
        for j in range(1,N): # 열 반복
            if board[i][j] == prev: # 전 숫자랑 같을 때
                same_count += 1
                
            elif board[i][j] == prev - 1: # 전 숫자보다 작을 때
                if N - j >= L:
                    check = board[i][j]
                    for j2 in range(j,j+L):
                        if board[i][j2] != check:
                            flag = False
                            break
                        slope[i][j2] = True
                    if not flag:
                        break
                    else:                        
                        prev = board[i][j]
                        same_count = 1
                else:
                    flag = False
                    break
                
            elif board[i][j] == prev + 1: # 전 숫자보다 클 때
                if same_count >= L:
                    prev = board[i][j]
                    same_count = 1
                    if j >= L:
                        for j2 in range(j-1,j-1-L,-1):
                            if not slope[i][j2]:
                                slope[i][j2] = True
                            else:
                                flag = False
                                break
                    else:
                        flag = False
                        break
                else: 
                    flag = False
                    break
            else: # 해당 사항 없으면 다음줄 ㄱㄱ
                flag = False
                break
            
        if flag:
            # print("#",i)
            row_count += 1
            
    return row_count

# 열기준
def check_col():
    slope = [[False] * N for _ in range(N)]
    col_count = 0
    for i in range(N):
        prev = board[0][i] # 이전 숫자
        same_count = 1
        flag = True
        for j in range(1,N): # 열 반복
            if board[j][i] == prev: # 전 숫자랑 같을 때
                same_count += 1
                
            elif board[j][i] == prev - 1: # 전 숫자보다 작을 때
                if N - j >= L:
                    check = board[j][i]
                    for j2 in range(j,j+L):
                        if board[j2][i] != check:
                            flag = False
                            break
                        slope[j2][i] = True
                    if not flag:
                        break
                    else:                        
                        prev = board[j][i]
                        same_count = 1
                else:
                    flag = False
                    break
                
            elif board[j][i] == prev + 1: # 전 숫자보다 클 때
                if same_count >= L:
                    prev = board[j][i]
                    same_count = 1
                    if j >= L:
                        for j2 in range(j-1,j-1-L,-1):
                            if not slope[j2][i]:
                                slope[j2][i] = True
                            else:
                                flag = False
                                break
                    else:
                        flag = False
                        break
                else: 
                    flag = False
                    break
            else: # 해당 사항 없으면 다음줄 ㄱㄱ
                flag = False
                break
            
        if flag:
            # print("#",i)
            col_count += 1
            
    return col_count   

print(check_row() + check_col())