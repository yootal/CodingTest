from sys import stdin
from collections import defaultdict
input = stdin.readline

def bimatch(x):
    if vis[x]:
        return False
    vis[x] = True
    for nxt in graph[x]:
        if not select[nxt] or bimatch(select[nxt]):
            select[nxt] = x
            return True
    return False 

t = int(input())
for _ in range(t):
    n,m = map(int,input().split())
    select = [0] * (n+1)
    graph = defaultdict(list)
    
    for i in range(1,m+1):
        a,b = map(int,input().split())
        graph[i].extend(list(range(a,b+1)))
        
    for i in range(1,m+1):
        vis = [False] * (m+1)
        bimatch(i)
        
    ans = 0
    for i in range(1,n+1):
        if select[i] > 0:
            ans += 1
    print(ans)
        