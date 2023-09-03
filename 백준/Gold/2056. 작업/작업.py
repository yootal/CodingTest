import sys, heapq
input=sys.stdin.readline
from collections import defaultdict, deque

n = int(input())
work = defaultdict(list)
indegree = defaultdict(int)
need_time = [0] * (n+1)

for i in range(1,n+1):
    inp = list(map(int,input().split()))
    need_time[i] = inp[0]
    indegree[i] += inp[1]
    for w in inp[2:]:
        work[w].append(i)

q = []
for i in range(1,n+1):
    if indegree[i] == 0:
        heapq.heappush(q,(need_time[i],i))

time = 0
while True:
    while q and time == q[0][0]:
        work_time, work_num = heapq.heappop(q)
        for nxt in work[work_num]:
            indegree[nxt] -= 1
            if indegree[nxt] == 0:
                heapq.heappush(q,(work_time + need_time[nxt],nxt))
    if not q:
        break
    time += 1
print(time)