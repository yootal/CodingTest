import sys
input=sys.stdin.readline

def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    return p[x]

def union(u,v):
    u = find(u)
    v = find(v)
    if u == v:
        return False
    if p[u] < p[v]:
        p[v] = u
    else:
        p[u] = v
    return True

v = int(input())
p = [i for i in range(v+2)]
edge = []
for i in range(1,v+1):
    self_cost = int(input())
    edge.append((self_cost,v+1,i))
for i in range(1,v+1):
    costs = list(map(int,input().split()))
    for j in range(1,v+1):
        if i == j:
            continue
        edge.append((costs[j-1],i,j))
edge.sort()

cnt = 0
ans = 0
for i in range(len(edge)):
    c,a,b = edge[i]
    if not union(a,b):
        continue
    ans += c
    cnt += 1
    if cnt == v:
        break
    
print(ans)
