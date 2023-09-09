import sys
from collections import defaultdict
input = sys.stdin.readline

def insert(route):
    global unused
    v = root
    for r in route:
        if not nxt[v][r]:
            nv = nxt[v][r] = unused
            unused += 1
        else:
            nv = nxt[v][r]
        depth[nv] = depth[v] + 1
        name[nv] = r
        v = nv
        
def dfs(v):
    if v != root:
        for _ in range(depth[v]):
            print(" ",end = "")
        print(name[v])
    sorted_nxt = sorted(nxt[v].items(), key=lambda x: x[0])
    for sub in sorted_nxt:
        dfs(sub[1])
    
root = 1
unused = 2
mx = 500 * 80 # 최대 등장 가능
check = [False] * mx
nxt = [defaultdict(int) for _ in range(mx)]   
depth = defaultdict(int)
name = defaultdict(str)

n = int(input())
depth[root] = -1
for _ in range(n):
    inp = input().rstrip()
    cur = ""
    route = []
    for c in inp:
        if c == '\\':
            route.append(cur)
            cur = ""
        else:
            cur += c
    route.append(cur)
    insert(route)
    
dfs(root)
