from sys import stdin
from math import ceil, log2
input = stdin.readline

def init(node,st,ed):
    if st == ed:
        tree[node] = num_idx[st]
        return tree[node]
    mid = (st + ed) // 2
    tree[node] = min(init(2*node,st,mid),init(2*node+1,mid+1,ed),key=lambda x: x[0])
    return tree[node]

def segment_min(node):
    return tree[node]

def update(node,st,ed,idx,diff):
    if idx < st or idx > ed:
        return
    if st == ed:
        tree[node] = (diff,idx+1)
    else:
        mid = (st + ed) // 2
        update(node*2,st,mid,idx,diff)
        update(node*2+1,mid+1,ed,idx,diff)
        tree[node] = min(tree[node*2],tree[node*2+1])

n = int(input())
h = ceil(log2(n))
tree_size = 1 << (h+1)
tree = [0] * tree_size
num = list(map(int,input().split()))
num_idx = []
for i in range(1,n+1):
    num_idx.append((num[i-1],i))
m = int(input())
    
init(1,0,n-1)
    
for _ in range(m):
    c = list(map(int,input().split()))
    if c[0] == 1:
        update(1,0,n-1,c[1]-1,c[2])
    else:
        print(segment_min(1)[1])