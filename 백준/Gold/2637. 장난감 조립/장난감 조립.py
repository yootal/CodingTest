import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n = int(input())
m = int(input())
indegree = defaultdict(int)
base = [True] * (n+1)
count = [0] * (n+1)
product_cnt = [[] for _ in range(n+1)]

for _ in range(m):
    x,y,k = map(int,input().split())
    base[x] = False
    indegree[y] += 1
    product_cnt[x].append((y,k))

q = deque([n])
count[n] = 1

while q:
    p = q.popleft()
    for nxt,cnt in product_cnt[p]:
        count[nxt] += cnt * count[p]
        indegree[nxt] -= 1
        if indegree[nxt] == 0:
            q.append(nxt)
            
for i in range(1,n+1):
    if base[i]:
        print(i,count[i])