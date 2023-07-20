import sys
input = sys.stdin.readline

n = int(input())
board = []
for _ in range(n):
    board.append(list(map(int,input().split())))
    
count1 = 0
count2 = 0
count3 = 0 

def quad_tree(row,col,n):
    global count1, count2, count3
    check = board[row][col]
    
    for i in range(row,row+n):
        for j in range(col,col+n):
            if board[i][j] != check:
                quad_tree(row,col,n//3)
                quad_tree(row,col+(n//3),n//3)
                quad_tree(row,col+(n//3)*2,n//3)
                quad_tree(row+(n//3),col,n//3)
                quad_tree(row+(n//3),col+(n//3),n//3)
                quad_tree(row+(n//3),col+(n//3)*2,n//3)
                quad_tree(row+(n//3)*2,col,n//3)
                quad_tree(row+(n//3)*2,col+(n//3),n//3)
                quad_tree(row+(n//3)*2,col+(n//3)*2,n//3)
                return
            
    if check == -1:
        count1 += 1
    elif check == 0:
        count2 += 1
    else: count3 += 1
    return
         
quad_tree(0,0,n)

print(count1)
print(count2)
print(count3)
            
