import sys
input=sys.stdin.readline

n,m = map(int,input().split())
parent = list(range(n+1))

def find_parent(parent,cur):
    if parent[cur] != cur:
        return find_parent(parent,parent[cur])
    return cur

def union_parent(parent,a,b):
    a = find_parent(parent,a)
    b = find_parent(parent,b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

cnt = 0
for _ in range(m):
    s,e = map(int,input().split())
    if find_parent(parent,s) == find_parent(parent,e):
        cnt += 1
    union_parent(parent,s,e)

link = 0
for i in range(1,n):
    if find_parent(parent,i) != find_parent(parent,i+1):
        union_parent(parent,i,i+1)
        link += 1
        
print(cnt + link)