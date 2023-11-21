from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

n = int(input())
ans = [0] * (n+1)
time = [0] * (n+1)
indegree = [0] * (n+1)
graph = defaultdict(list)

for i in range(1,n+1):
    inp = list(map(int,input().split()))
    time[i] = inp[0]
    for p in inp[1:-1]:
        indegree[i] += 1
        graph[p].append(i)

hq = []
for i in range(1,n+1):
    if not indegree[i]:
        heappush(hq,(time[i],i))

while hq:
    t, cur = heappop(hq)
    ans[cur] = t
    for nxt in graph[cur]:
        indegree[nxt] -= 1
        if not indegree[nxt]:
            heappush(hq,(t + time[nxt],nxt))

for x in range(1,n+1):
    print(ans[x])
