import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**6)
from collections import defaultdict

def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    return p[x]

def union(u,v):
    u = find(u)
    v = find(v)
    if u == v:
        return False
    if p[u] == p[v]:
        p[u] -= 1
    if p[u] < p[v]:
        p[v] = u
    else:
        p[u] = v
    return True

v,e = map(int,input().split())
p = [i for i in range(v+1)]
edge = []
for _ in range(e):
    a,b,c = map(int,input().split())
    edge.append((c,a,b))
edge.sort()

cnt = 0
ans = 0
for i in range(e):
    c,a,b = edge[i]
    if not union(a,b):
        continue
    ans += c
    cnt += 1
    if cnt == v-1:
        break

print(ans)