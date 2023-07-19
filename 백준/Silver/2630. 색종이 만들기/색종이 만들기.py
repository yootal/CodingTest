import sys
input = sys.stdin.readline

n = int(input())
board = []
for _ in range(n):
    board.append(list(map(int,input().split())))
    
blue_count = 0
white_count = 0

def quad_tree(row,col,n):
    global blue_count, white_count
    
    check = board[row][col]
    
    for i in range(row,row+n):
        for j in range(col,col+n):
            if board[i][j] != check:
                quad_tree(row,col,n//2)
                quad_tree(row+(n//2),col,n//2)
                quad_tree(row,col+(n//2),n//2)
                quad_tree(row+(n//2),col+(n//2),n//2)
                return
            
    if check == 1:
        blue_count += 1
    else: white_count += 1
    return
            
quad_tree(0,0,n)
print(white_count)
print(blue_count)
            
