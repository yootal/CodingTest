from collections import defaultdict

def dfs(cur, cnt):
    global ans
    if cnt > ans:
        ans = cnt
    for nxt in graph[cur]:
        if not vis[nxt]:
            vis[nxt] = 1
            dfs(nxt,cnt + 1)
            vis[nxt] = 0
            
t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    graph = defaultdict(list)
    for _ in range(m):
        x,y = map(int,input().split())
        graph[x].append(y)
        graph[y].append(x)
    ans = 0
    vis = [0] * (n+1)
    for i in range(1,n+1):
        vis[i] = True
        dfs(i,1)
        vis[i] = False    
        
    print(f"#{case} {ans}")