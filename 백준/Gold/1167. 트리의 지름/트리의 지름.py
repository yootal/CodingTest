import sys
sys.setrecursionlimit(10**6)
from collections import defaultdict
input = sys.stdin.readline

v = int(input())
graph = defaultdict(list)
for _ in range(v):
    inp = list(map(int,input().split()))
    for i in range(1,len(inp)-1,2):
        graph[inp[0]].append((inp[i],inp[i+1]))
        graph[inp[i]].append((inp[0],inp[i+1]))

mx_cost = 0
mx_node = 0

def dfs(cur,d):
    global mx_cost, mx_node
    vis[cur] = True
    if mx_cost < d:
        mx_cost = d
        mx_node = cur
    for nxt,cost in graph[cur]:
        if vis[nxt]:
            continue
        dfs(nxt,d+cost)
        
vis = [False] * (v+1)
dfs(1,0)
vis = [False] * (v+1)
dfs(mx_node,0)
print(mx_cost)