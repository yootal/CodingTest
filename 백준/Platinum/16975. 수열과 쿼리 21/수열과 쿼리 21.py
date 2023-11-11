from sys import stdin
from math import ceil, log2
input = stdin.readline

def init(node,st,ed):
    if st == ed:
        tree[node] = num[st]
        return tree[node]
    mid = (st + ed) // 2
    init(2*node,st,mid)
    init(2*node+1,mid+1,ed)

def query(node,st,ed,idx,value):
    if idx > ed or idx < st:
        return 0
    value += tree[node]
    if st == ed:
        return value 
    mid = (st + ed) // 2
    return query(node*2,st,mid,idx,value) + query(node*2+1,mid+1,ed,idx,value)

def update(node,st,ed,l,r,diff):
    if l > ed or r < st:
        return
    if l <= st and ed <= r:
        tree[node] += diff
        return
    mid = (st + ed) // 2
    update(node*2,st,mid,l,r,diff)
    update(node*2+1,mid+1,ed,l,r,diff)

n = int(input())
h = ceil(log2(n))
tree_size = 1 << (h+1)
tree = [0] * tree_size
num = list(map(int,input().split()))
m = int(input())

init(1,0,n-1)
    
for _ in range(m):
    command = list(map(int,input().split()))
    if command[0] == 1:
        update(1,0,n-1,command[1]-1,command[2]-1,command[3])
    else:
        print(query(1,0,n-1,command[1]-1,0))