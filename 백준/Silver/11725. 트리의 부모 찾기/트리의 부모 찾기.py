import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import defaultdict

n = int(input())
graph = defaultdict(list)
parent = [0] * (n+1)
    
for _ in range(n-1):
    a,b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)
    
def dfs(i):
    for nxt in graph[i]:
        if parent[i] == nxt:
            continue
        parent[nxt] = i
        dfs(nxt) 

dfs(1)
for p in parent[2:]:
    print(p)