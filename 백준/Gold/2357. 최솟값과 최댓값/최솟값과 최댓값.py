from sys import stdin
from math import ceil, log2
input = stdin.readline

def min_init(node,st,ed):
    if st == ed:
        min_tree[node] = num[st]
        return min_tree[node]
    mid = (st + ed) // 2
    min_tree[node] = min(min_init(2*node,st,mid),min_init(2*node+1,mid+1,ed))
    return min_tree[node]

def max_init(node,st,ed):
    if st == ed:
        max_tree[node] = num[st]
        return max_tree[node]
    mid = (st + ed) // 2
    max_tree[node] = max(max_init(2*node,st,mid),max_init(2*node+1,mid+1,ed))
    return max_tree[node]

def min_query(node,st,ed,l,r):
    if st > r or ed < l:
        return 1000000001
    if l <= st and ed <= r:
        return min_tree[node]
    mid = (st + ed) // 2
    return min(min_query(node*2,st,mid,l,r),min_query(node*2+1,mid+1,ed,l,r))

def max_query(node,st,ed,l,r):
    if st > r or ed < l:
        return 0
    if l <= st and ed <= r:
        return max_tree[node]
    mid = (st + ed) // 2
    return max(max_query(node*2,st,mid,l,r),max_query(node*2+1,mid+1,ed,l,r))

n,m = map(int,input().split())

h = ceil(log2(n))
tree_size = 1 << (h+1)
min_tree = [0] * tree_size
max_tree = [0] * tree_size

num = []
for _ in range(n):
    num.append(int(input()))
    
min_init(1,0,n-1)
max_init(1,0,n-1)
    
for _ in range(m):
    a,b = map(int,input().split())
    print(min_query(1,0,n-1,a-1,b-1),max_query(1,0,n-1,a-1,b-1))  