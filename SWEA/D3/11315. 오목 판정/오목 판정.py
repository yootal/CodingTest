d = [(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]

def solve():
    for i in range(n):
        for j in range(n):
            if board[i][j] == 1:
                for dx,dy in d:
                    nx = i + dx
                    ny = j + dy
                    if 0 > nx or n-1 < nx or 0 > ny or n-1 < ny:
                        continue
                    if board[nx][ny] == 1:
                        flag = True
                        for _ in range(3):
                            nx += dx
                            ny += dy
                            if 0 > nx or n-1 < nx or 0 > ny or n-1 < ny:
                                flag = False
                                break
                            if board[nx][ny] != 1:
                                flag = False
                                break
                        if flag:
                            print(f"#{case} YES")
                            return
    print(f"#{case} NO")
    return
                        
t = int(input())
for case in range(1,t+1):
    n = int(input())
    board = [[1 if x == 'o' else 0 for x in list(input().rstrip())] for _ in range(n)]
    solve()