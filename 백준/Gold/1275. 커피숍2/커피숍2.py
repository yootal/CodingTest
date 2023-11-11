from sys import stdin
from math import ceil, log2
input = stdin.readline

def init(node,st,ed):
    if st == ed:
        tree[node] = num[st]
        return tree[node]
    mid = (st + ed) // 2
    tree[node] = init(2*node,st,mid) + init(2*node+1,mid+1,ed)
    return tree[node]

def segment_sum(node,st,ed,l,r):
    if l > ed or r < st:
        return 0
    if l <= st and ed <= r:
        return tree[node]
    mid = (st + ed) // 2
    return segment_sum(node*2,st,mid,l,r) + segment_sum(node*2+1,mid+1,ed,l,r)

def update(node,st,ed,idx,diff):
    if idx < st or idx > ed:
        return
    tree[node] += diff
    if st != ed:
        mid = (st + ed) // 2
        update(node*2,st,mid,idx,diff)
        update(node*2+1,mid+1,ed,idx,diff)

n,q = map(int,input().split())

h = ceil(log2(n))
tree_size = 1 << (h+1)
tree = [0] * tree_size

num = list(map(int,input().split()))
    
init(1,0,n-1)
    
for _ in range(q):
    x,y,a,b = map(int,input().split())
    _x = min(x,y)
    _y = max(x,y)
    diff = b - num[a-1]
    num[a-1] = b
    print(segment_sum(1,0,n-1,_x-1,_y-1))
    update(1,0,n-1,a-1,diff)