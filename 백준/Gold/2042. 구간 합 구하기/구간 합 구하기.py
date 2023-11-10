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

n,m,k = map(int,input().split())

h = ceil(log2(n))
tree_size = 1 << (h+1)
tree = [0] * tree_size

num = []
for _ in range(n):
    num.append(int(input()))
    
init(1,0,n-1)
    
for _ in range(m+k):
    a,b,c = map(int,input().split())
    if a == 1:
        diff = c - num[b-1]
        num[b-1] = c
        update(1,0,n-1,b-1,diff)
    elif a == 2:
        print(segment_sum(1,0,n-1,b-1,c-1))