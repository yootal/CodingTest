import sys
input = sys.stdin.readline

def check():
    for j in range(N):
        k = j
        for i in range(H):
            if board[i][k]:
                k += 1
            elif k > 0 and board[i][k-1]:
                k -= 1
        if k != j:
            return False
    return True

def dfs(cnt,x,y):
    global min_count
    if check(): # 각 출발점이 도착점에 정상적으로 도착하는지 체크
        min_count = min(min_count,cnt)
        return
    elif cnt == 3 or min_count <= cnt:
        return
    for i in range(x,H):
        if i == x:
            k = y
        else:
            k = 0
        for j in range(k, N-1):
            if not board[i][j] and not board[i][j+1]:
                if j > 0 and board[i][j-1]: 
                    continue
                board[i][j] = True
                dfs(cnt + 1, i , j+2)
                board[i][j] = False

N,M,H = map(int,input().split())  
board = [[False] * (N) for _ in range(H)]

if M == 0: 
        print(0)
        exit(0)
for _ in range(M):
        a, b = map(int,input().split())
        board[a - 1][b - 1] = True
        
min_count = 4
dfs(0, 0, 0)
print(min_count if min_count < 4 else -1)