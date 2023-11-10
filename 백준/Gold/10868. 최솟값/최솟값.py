from sys import stdin
from math import log2, ceil
input = stdin.readline

def init(node,st,ed):
    if st == ed:
        tree_min[node] = num[st]
        return tree_min[node] 
    mid = (st + ed) // 2
    tree_min[node] = min(init(node*2,st,mid),init(node*2+1,mid+1,ed))
    return tree_min[node]   

def min_query(node,st,ed,l,r):
    if st > r or ed < l:
        return 1000000001
    if l <= st and ed <= r:
        return tree_min[node]
    mid = (st + ed) // 2
    return min(min_query(node*2,st,mid,l,r),min_query(node*2+1,mid+1,ed,l,r))
    
n,m = map(int,input().split())
h = int(ceil(log2(n)))
tree_size = 1 << (h+1) # 2의 (h+1) 제곱, 비트 시프트
num = []
tree_min = [0] * tree_size

for _ in range(n):
    num.append(int(input()))

init(1,0,n-1)

for _ in range(m):
    a,b = map(int,input().split())
    print(min_query(1,0,n-1,a-1,b-1))