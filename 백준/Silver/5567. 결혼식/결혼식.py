from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

n = int(input())
m = int(input())
friend = [[] for _ in range(n+1)]
vis = [False] * n
for _ in range(m):
    s,e = map(int,input().split())
    friend[s].append(e)
    friend[e].append(s)
    
def dfs(start, depth):
    global cnt
    vis[start-1] = True
    if depth == 2:
        return
    friend[start].sort()
    for f in friend[start]:
        if not vis[f-1]:
            cnt += 1
        dfs(f,depth+1)
    return

cnt = 0
dfs(1,0)
print(cnt)