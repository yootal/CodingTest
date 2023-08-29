import sys
input=sys.stdin.readline

n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
vis = [0 for _ in range(n)]

def dfs(point):
    for i in range(n):
        if graph[point][i] == 1 and vis[i] == 0:
            vis[i] = 1
            dfs(i)
            
for i in range(n):
    dfs(i)
    for j in range(n):
        if vis[j] == 1:
            print(1, end=" ")
        else:
            print(0, end=" ") 
    print()
    vis = [0 for _ in range(n)]        