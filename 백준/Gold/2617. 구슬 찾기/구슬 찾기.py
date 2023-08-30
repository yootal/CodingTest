import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import defaultdict

n,m = map(int,input().split())
bead = defaultdict(list)  
criteria = n // 2
vis = [False] * n
up_cnt = [0] * n
down_cnt = [0] * n

for _ in range(m):
    heavy,light = map(int,input().split())
    bead[light].append(heavy)
    bead[-heavy].append(-light)
        
def dfs(i):
    global cnt
    vis[i-1] = True
    for b in bead[i]:
        if not vis[b-1]:
            cnt += 1
            dfs(b)
            
def dfs2(i):
    global cnt
    vis[-i-1] = True
    for b in bead[i]:
        if not vis[-b-1]:
            cnt += 1
            dfs2(b)
        
for i in range(1,n+1):
    cnt = 0
    dfs(i)
    up_cnt[i-1] = cnt
    vis = [False] * n
    cnt = 0 
    dfs2(-i)
    down_cnt[i-1] = cnt
    vis = [False] * n 
   
ans = 0 
for c in up_cnt:
    if c > criteria:
        ans += 1
for c in down_cnt:
    if c > criteria:
        ans += 1
print(ans)