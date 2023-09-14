import sys
from heapq import heappush, heappop
from collections import defaultdict
input=sys.stdin.readline

n = int(input())
deadline = defaultdict(list)
q = []
length = 0

for _ in range(n):
    d,w = map(int,input().split())
    length = max(length,d)
    deadline[d].append(w)

ans = 0
for i in range(length,0,-1):
    for w in deadline[i]:
        heappush(q,(-w,i))

    if q:
        value,limit = heappop(q)
        ans += -value
    
print(ans)