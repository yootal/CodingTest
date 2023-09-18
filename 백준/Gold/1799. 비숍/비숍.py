import sys
input = sys.stdin.readline

def bishop(idx,cnt,color):
    if idx == 2 * n:
        ans[color] = max(ans[color],cnt)
        return
    for x,y in board[color][idx]:
        if used[color][x + y]:
            continue
        used[color][x+y] = True
        bishop(idx + 1, cnt + 1, color)
        used[color][x+y] = False
    bishop(idx + 1, cnt, color)
    
n = int(input())
ans = [0,0]
board = [[[] for _ in range(2 * n) ] for _ in range(2)]
used = [[False] * (2 * n)  for _ in range(2)]
for r in range(n):
    inp = list(map(int,input().split()))
    for c,v in enumerate(inp):
        if v == 1:
            # \ 방향 대각선
            board[(r + c + 1) % 2][n + r - c - 1].append((r,c)) 

bishop(0,0,0)
bishop(0,0,1)

print(sum(ans))