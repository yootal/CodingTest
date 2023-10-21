from sys import stdin, maxsize
input = stdin.readline

n = int(input())
stat = [list(map(int,input().split())) for _ in range(n)]
vis = [False] * n 

def recur(cnt):
    if cnt == n:
        score()
        return
    vis[cnt] = True
    recur(cnt+1)
    vis[cnt] = False
    recur(cnt+1)

def score():
    global ans
    team1 = 0
    team2 = 0
    for i in range(n-1):
        for j in range(i+1,n):
            if vis[i] and vis[j]:
                team1 += stat[i][j] + stat[j][i]
            elif not vis[i] and not vis[j]:
                team2 += stat[i][j] + stat[j][i]   
    diff = abs(team1 - team2)
    ans = min(ans,diff)   

ans = maxsize
recur(0)
print(ans)            