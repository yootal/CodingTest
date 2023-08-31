import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import defaultdict

def dfs(cur):
    global tree, flag
    for nxt in graph[cur]:
        if parent[cur] == nxt:
            continue
        if not vis[nxt]:
            vis[nxt] = True
            parent[nxt] = cur
            dfs(nxt)
        else:
            flag = False
            return
case = 0
while True:
    case += 1
    n,m = map(int,input().split())
    if n == 0 and m == 0:
        break
    graph = [[] for _ in range(n+1)]
    parent = defaultdict(int)
    vis = [True] + [False] * n
    for _ in range(m):
        a,b = map(int,input().split())
        graph[a].append(b)
        graph[b].append(a)
        
    tree = 0
    for cur in range(1,n+1):
        flag = True
        if not vis[cur]:
            dfs(cur)
            if flag:
                tree += 1
                
    if tree <= 0:
        print(f"Case {case}: No trees.")
    elif tree == 1:
        print(f"Case {case}: There is one tree.")
    else:
        print(f"Case {case}: A forest of {tree} trees.")
