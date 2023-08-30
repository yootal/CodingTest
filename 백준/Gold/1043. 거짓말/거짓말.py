import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n,m = map(int,input().split())
fact = list(map(int,input().split()))
fact_cnt = fact[0]
fact = fact[1:]
party = defaultdict(list)  
guest = defaultdict(list)
vis = [False] * m

for i in range(1,m+1):
    party_inp = list(map(int,input().split()))
    party[i] = party_inp[1:]
    for p in party_inp[1:]:
        guest[p].append(i)

def bfs(f):
    q = deque([f])
    while q:
        f = q.popleft()
        for f2 in guest[f]:
            if not vis[f2-1]:
                vis[f2-1] = True
                for p2 in party[f2]:
                    q.append(p2)

if fact_cnt == 0:
    print(m)
else:
    for i in range(fact_cnt):
        bfs(fact[i])
    print(vis.count(False))
 