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
    update_lazy(node,st,ed)
    if l > ed or r < st:
        return 0
    if l <= st and ed <= r:
        return tree[node]
    mid = (st + ed) // 2
    return segment_sum(node*2,st,mid,l,r) + segment_sum(node*2+1,mid+1,ed,l,r)

def update(node,st,ed,l,r,diff):
    update_lazy(node,st,ed)
    if l > ed or r < st:
        return
    if l <= st and ed <= r:
        tree[node] += (ed - st + 1) * diff
        if st != ed:
            lazy[node*2] += diff
            lazy[node*2+1] += diff
        return
    mid = (st + ed) // 2
    update(node*2,st,mid,l,r,diff)
    update(node*2+1,mid+1,ed,l,r,diff)
    tree[node] = tree[2*node] + tree[2*node+1]
    
def update_lazy(node,st,ed):
    if lazy[node]:
        tree[node] += (ed-st+1) * lazy[node]
        if st != ed:
            lazy[node*2] += lazy[node]
            lazy[node*2+1] += lazy[node]
        lazy[node] = 0

n,m,k = map(int,input().split())

h = ceil(log2(n))
tree_size = 1 << (h+1)

tree = [0] * tree_size
lazy = [0] * tree_size

num = []
for _ in range(n):
    num.append(int(input()))
    
init(1,0,n-1)
    
for _ in range(m+k):
    command = list(map(int,input().split()))
    if command[0] == 1:
        b = command[1]
        c = command[2]
        diff = command[3]
        update(1,0,n-1,b-1,c-1,diff)
    else:
        b = command[1]
        c = command[2]
        print(segment_sum(1,0,n-1,b-1,c-1))