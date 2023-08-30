import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline
from collections import defaultdict

n,m = map(int,input().split())
friend = defaultdict(list)  
vis = [-1] * n
score = [0] * n

for _ in range(m):
    s,e = map(int,input().split())
    friend[s].append(e)
    friend[e].append(s)
            
def dfs(i,depth,cnt):
    vis[i-1] = depth
    if cnt == n:
        
        return
    for f in friend[i]:
        if vis[f-1] == -1 or vis[f-1] > depth + 1:
            dfs(f, depth + 1, cnt + 1)
            
for i in range(1,n+1):
    dfs(i,0,1)
    score[i-1] = sum(vis)
    vis = [-1] * n

print(score.index(min(score)) + 1)