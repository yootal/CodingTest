from sys import stdin
input = stdin.readline

d = ((-1,0),(1,0),(0,-1),(0,1))

r,c = map(int,input().split())
board = [list(input().rstrip()) for _ in range(r)]

def dfs(x,y,cnt):
    global ans
    ans = max(ans,cnt)
    for i in range(4):
        nx = x + d[i][0]
        ny = y + d[i][1]
        if 0 <= nx < r and 0 <= ny < c and board[nx][ny] not in record:
            record.add(board[nx][ny])
            dfs(nx,ny,cnt+1)
            record.remove(board[nx][ny])

ans = 0
record = set(board[0][0])
dfs(0,0,1)
print(ans)