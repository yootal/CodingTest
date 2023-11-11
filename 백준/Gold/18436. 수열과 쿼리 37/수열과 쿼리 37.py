from sys import stdin
from math import ceil, log2
input = stdin.readline

def init(node,st,ed):
    if st == ed:
        if num[st] % 2 == 0:
            tree[node] = [1,0]
        else:
            tree[node] = [0,1]
        return tree[node]
    mid = (st + ed) // 2
    a = init(2*node,st,mid)
    b = init(2*node+1,mid+1,ed)
    tree[node] = [a[0]+b[0],a[1]+b[1]]
    return tree[node]

def query(node,st,ed,l,r):
    if l > ed or r < st:
        return [0,0]
    if l <= st and ed <= r:
        return tree[node]
    mid = (st + ed) // 2
    a = query(node*2,st,mid,l,r)
    b = query(node*2+1,mid+1,ed,l,r)
    return [a[0]+b[0],a[1]+b[1]]

def update(node,st,ed,idx,value):
    if idx < st or idx > ed:
        return
    if st == ed:
        if value % 2 == 0:
            tree[node] = [1,0]
        else:
            tree[node] = [0,1]
    if st != ed:
        mid = (st + ed) // 2
        update(node*2,st,mid,idx,value)
        update(node*2+1,mid+1,ed,idx,value)
        tree[node] = [tree[node*2][0]+tree[node*2+1][0],tree[node*2][1]+tree[node*2+1][1]]

n = int(input())
h = ceil(log2(n))
tree_size = 1 << (h+1)
tree = [[0,0] for _ in range(tree_size)]
num = list(map(int,input().split()))
m = int(input())

init(1,0,n-1)
    
for _ in range(m):
    a,b,c = map(int,input().split())
    if a == 1:
        if num[b-1] % 2 == c % 2:
            num[b-1] = c
            continue
        else:
            update(1,0,n-1,b-1,c)
            num[b-1] = c
    elif a == 2:
        print(query(1,0,n-1,b-1,c-1)[0])
    else:
        print(query(1,0,n-1,b-1,c-1)[1])