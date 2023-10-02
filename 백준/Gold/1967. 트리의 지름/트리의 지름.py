import sys
sys.setrecursionlimit(10**6)
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
graph = defaultdict(list)
for _ in range(n-1):
    p,c,w = map(int,input().split())
    graph[p].append((c,w))
    graph[c].append((p,w))
    
mx_cost = 0
mx_node = 0

def dfs(cur,value):
    global mx_cost, mx_node
    if mx_cost < value:
        mx_cost = value
        mx_node = cur
    for nxt,weight in graph[cur]:
        if vis[nxt]:
            continue
        vis[nxt] = True
        dfs(nxt,value+weight)
        
vis = [False] * (n+1)
vis[1] = True
dfs(1,0)    

vis = [False] * (n+1)
vis[mx_node] = True
dfs(mx_node,0)

print(mx_cost)    
    