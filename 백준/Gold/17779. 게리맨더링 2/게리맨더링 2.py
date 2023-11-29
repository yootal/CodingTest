from sys import stdin, maxsize
input = stdin.readline

n = int(input())
board = [[0] * (n+1)] + [[0] + list(map(int,input().split())) for _ in range(n)]
ans = maxsize

def solve(x,y,d1,d2):
    global ans
    areas = [0] * 5
    check = [[0] * (n+1) for _ in range(n+1)]
    
    for d in range(d1+1):
        check[x+d][y-d] = 1
        check[x+d2+d][y+d2-d] = 1
    for d in range(d2+1):
        check[x+d][y+d] = 1
        check[x+d1+d][y-d1+d] = 1
    for i in range(x+1, x+d1+d2):
        flag = False
        for j in range(1,n+1):
            if check[i][j]:
                flag = not flag
            if flag:
                check[i][j] = 1
    
    for r in range(1,n+1):
        for c in range(1,n+1):
            if 1 <= r < x + d1 and 1 <= c <= y and not check[r][c]:
                areas[0] += board[r][c]
            elif 1 <= r <= x + d2 and y < c <= n and not check[r][c]:
                areas[1] += board[r][c]
            elif x + d1 <= r <= n and 1 <= c < y - d1 + d2 and not check[r][c]:
                areas[2] += board[r][c]
            elif x + d2 < r <= n and y - d1 + d2 <= c <= n and not check[r][c]:
                areas[3] += board[r][c] 
            elif check[r][c]:
                areas[4] += board[r][c]
                
    mxarea = max(areas)
    mnarea = min(areas)
    ans = min(ans,mxarea - mnarea)
    
for x in range(1,n+1):
    for y in range(1,n+1):
        for d1 in range(1,n+1):
            for d2 in range(1,n+1):
                if 1 <= x < x + d1 + d2 <= n and 1 <= y - d1 < y < y + d2 <= n:
                    solve(x,y,d1,d2)

print(ans)
