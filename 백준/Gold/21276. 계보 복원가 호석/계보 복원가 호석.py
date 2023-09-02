import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n = int(input())
village = list(input().rstrip().split())
village.sort()
m = int(input())
familly = defaultdict(list)
indegree = defaultdict(int)
ch = defaultdict(list)

for _ in range(m):
    e,s = input().rstrip().split()         
    familly[s].append(e)
    familly[s].sort()
    indegree[e] += 1

q = deque()
for resident in village:
    if indegree[resident] == 0:
        q.append(resident)
        
print(len(q))
print(*q)

for resident in village:
    for member in familly[resident]:
        if indegree[member] - indegree[resident] == 1:
            ch[resident].append(member)
            
for i in range(n):
    print(village[i],len(ch[village[i]]),end = " ")
    for c in ch[village[i]]:
        print(c, end = " ")
    print()