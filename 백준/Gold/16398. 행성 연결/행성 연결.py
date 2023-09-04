import sys
input = sys.stdin.readline
from collections import defaultdict
from heapq import heappush, heappop

n = int(input())
graph = defaultdict(list)
check = [False] * (n+1)

for i in range(n):
    inp = list(map(int,input().split()))
    for j in range(n):
        if i != j:
            graph[i+1].append((j+1, inp[j]))
            
q = []
check[1] = True
for nxt,cost in graph[1]:
    heappush(q,(cost,1,nxt))
    
cnt = 0
ans = 0
while cnt < n - 1:
    c,a,b = heappop(q)
    if check[b]:
        continue
    ans += c
    cnt += 1
    check[b] = True
    for nxt,cost in graph[b]:
        if not check[nxt]:
            heappush(q,(cost,b,nxt))
            
print(ans)
    