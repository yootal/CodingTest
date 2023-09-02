import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n,m = map(int,input().split())
graph = defaultdict(list)
indegree = [0] * n
for _ in range(m):
    a,b = map(int,input().split())
    graph[a].append(b)
    indegree[b-1] += 1

q = deque()
ans = []
for i in range(1,n+1):
    if indegree[i-1] == 0:
        q.append(i)
while q:
    x = q.popleft()
    ans.append(x)
    for ind in graph[x]:
        indegree[ind-1] -= 1
        if indegree[ind-1] == 0:
            q.append(ind)
print(*ans)
