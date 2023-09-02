import sys, heapq
input=sys.stdin.readline
from collections import defaultdict

n,m = map(int,input().split())
question = defaultdict(list)
indegree = [0] * (n+1)

for _ in range(m):
    s,e = map(int,input().split())    
    question[s].append(e)
    indegree[e] += 1

q = []
for i in range(1,n+1):
    if indegree[i] == 0:
        q.append(i)
        
ans = []
while q:
    q_num = heapq.heappop(q)
    ans.append(q_num)
    for que in question[q_num]:
        indegree[que] -= 1
        if indegree[que] == 0:
            heapq.heappush(q,que)
            
print(*ans)