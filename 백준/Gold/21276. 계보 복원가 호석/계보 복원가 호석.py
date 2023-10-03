import sys
from collections import defaultdict
input = sys.stdin.readline

indegree = defaultdict(int)
graph = defaultdict(list)
child = defaultdict(list)

n = int(input())
resident = sorted(list(input().rstrip().split()))
m = int(input())
for _ in range(m):
    x,y = input().rstrip().split()
    graph[y].append(x)
    indegree[x] += 1

ancestor = []
for name in resident:
    if not indegree[name]:
        ancestor.append(name)

print(len(ancestor))
print(*ancestor)

for name in resident:
    for member in graph[name]:
        if indegree[member] - indegree[name] == 1:
            child[name].append(member)
            
for name in resident:
    print(name,len(child[name]),end=" ")
    if len(child[name]) > 0:
        print(*sorted(child[name]))
    else:
        print()
    