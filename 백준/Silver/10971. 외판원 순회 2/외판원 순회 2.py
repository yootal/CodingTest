from sys import stdin, maxsize
input = stdin.readline

n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]

def bt(st,cur,total,cnt):
    global ans
    if cnt == n:
        if board[cur][st]:
            total += board[cur][st]
            ans = min(ans,total)
        return
    for x in range(n):
        if not vis[x] and board[cur][x] and total + board[cur][x] < ans:
            vis[x] = True
            bt(st,x,total+board[cur][x],cnt+1)
            vis[x] = False      

ans = maxsize
vis = [False] * n
for i in range(n):
    vis[i] = True
    bt(i,i,0,1)
    vis[i] = False
print(ans)