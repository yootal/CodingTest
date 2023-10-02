import sys
sys.setrecursionlimit(10**6)
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
state=[[-1,-1] for _ in range(n+1)]
graph = defaultdict(list)
for _ in range(n-1):
    u,v = map(int,input().split())
    graph[u].append(v)    
    graph[v].append(u) 
tree = defaultdict(list)   
    
def make(curr,prev):
    for nxt in graph[curr]:
        if nxt == prev:
            continue
        tree[curr].append(nxt)
        make(nxt,curr)
        
def dp(curr,check):
    if state[curr][check] != -1:
        return state[curr][check]
    val = 0
    if check:
        for nxt in tree[curr]:
            val += min(dp(nxt,False),dp(nxt,True))
    else:
        for nxt in tree[curr]:
            val += dp(nxt,True)
    state[curr][check] = val + check
    return state[curr][check]

make(1,-1)
print(min(dp(1,False),dp(1,True)))