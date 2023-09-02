import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n,m = map(int,input().split())
graph = defaultdict(set)
indegree = [0] * n
for _ in range(m):
    singer_order = list(map(int,input().split()))
    for i in range(2,singer_order[0] + 1):
        if singer_order[i] not in graph[singer_order[i-1]]:
            graph[singer_order[i-1]].add(singer_order[i])
            indegree[singer_order[i]-1] += 1
        
if 0 not in indegree:
    print(0)
    exit()

q = deque()
ans = []
for i in range(1,n+1):
    if indegree[i-1] == 0:
        q.append(i)

while q:
    x = q.popleft()
    ans.append(x)
    for ind in list(graph[x]):
        indegree[ind-1] -= 1
        if indegree[ind-1] == 0:
            q.append(ind)
            
if len(ans) != n:
    print(0)
else:
    [print(a) for a in ans]