import sys
input = sys.stdin.readline

n = int(input())
board = []
for _ in range(n):
    board.append(list(input().rstrip()))
    
ans = ""

def quad_tree(row,col,n):
    global ans
    check = board[row][col]
    
    for i in range(row,row+n):
        for j in range(col,col+n):
            if board[i][j] != check:
                ans += "("
                quad_tree(row,col,n//2)
                quad_tree(row,col+(n//2),n//2)
                quad_tree(row+(n//2),col,n//2)
                quad_tree(row+(n//2),col+(n//2),n//2)
                ans += ")"
                return
            
    if check == "1":
        ans += "1"
    else: ans += "0"
    return
         
quad_tree(0,0,n)
print(ans)
            
