from sys import stdin, maxsize 
input = stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

def plant(x,y,check):
    cost = price[x][y]
    for dx,dy in d:
        nx = x + dx
        ny = y + dy
        board[nx][ny] = check
        cost += price[nx][ny]
    if check:
        return cost 

def check(x,y):
    for dx,dy in d:
        nx = x + dx
        ny = y + dy
        if nx < 0 or nx > n-1 or ny < 0 or ny > n-1:
            return False
        if board[nx][ny]:
            return False
    return True    

def back_tracking(st,cnt,total):
    global ans
    if cnt == 3:
        ans = min(ans,total)
        return
    for i in range(st,n):
        for j in range(n):
            if not board[i][j]:
                if check(i,j):
                    board[i][j] = True
                    cost = plant(i,j,True)
                    back_tracking(i,cnt+1,total+cost)
                    board[i][j] = False
                    plant(i,j,False)
                    
n = int(input())
price = [list(map(int,input().split())) for _ in range(n)]
board = [[False] * n for _ in range(n)]
ans = maxsize
back_tracking(0,0,0)
print(ans)