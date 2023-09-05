import sys
input = sys.stdin.readline

def back_tracking(x, cnt, cost):
    global ans
    if cnt == n:
        ans = min(ans,cost)
        return
    for nxt in range(n):
        if not vis[nxt]:
            vis[nxt] = True
            back_tracking(nxt, cnt + 1, cost + graph[x][nxt])
            vis[nxt] = False

n,s = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

vis = [False] * n 
vis[s] = True
ans = sys.maxsize

back_tracking(s,1,0)
print(ans)    
