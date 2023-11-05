from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

route = defaultdict(list)
n = int(input())
total = 0
for i in range(n):
    inp = input().rstrip()
    for j in range(n):
        l = None
        if inp[j].islower():
            l = ord(inp[j]) - 96
        elif inp[j].isupper():
            l = ord(inp[j]) - 38
        else:
            l = 0
        total += l
        if i != j and l != 0:
            route[i].append((j,l))    
            route[j].append((i,l))    

vis = [False] * n
hq = []
heappush(hq,(0,0))
length = 0
while hq:
    len,cur = heappop(hq)
    if vis[cur]:
        continue
    vis[cur] = True
    length += len
    for nxt,len2 in route[cur]:
        if not vis[nxt]:
            heappush(hq,(len2,nxt))

if False in vis:
    print(-1)
else:
    print(total - length) 