import sys
from heapq import heappush, heappop
from collections import defaultdict, deque
input = sys.stdin.readline
inf = sys.maxsize

n = int(input())
m = int(input())
graph = defaultdict(list)
for _ in range(m):
    u,v,w = map(int,input().split())
    graph[u].append((w,v))
st, ed = map(int,input().split())
    
sdt = [inf] * (n+1)
pt = [0] * (n+1)
sdt[st] = 0
q = []
heappush(q,(sdt[st],st)) # 거리, 시작점

while q:
    dis,cur = heappop(q)
    if sdt[cur] != dis:
        continue
    for d,nxt in graph[cur]:
        if sdt[nxt] <= sdt[cur] + d:
            continue
        sdt[nxt] = sdt[cur] + d
        pt[nxt] = cur
        heappush(q,(sdt[nxt],nxt))
        
pre = ed
ans = deque()
while pre != st:
    ans.appendleft(pre)
    pre = pt[pre]
ans.appendleft(pre)
ans = list(ans)

print(sdt[ed])
print(len(ans))
print(*ans)