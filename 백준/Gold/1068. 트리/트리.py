import sys
input=sys.stdin.readline
from collections import defaultdict

def leaf_count(x):
    if x == erase:
        return 0
    if not child[x]:
        return 1
    if len(child[x]) == 1 and child[x][0] == erase:
        return 1
    ret = 0
    for nxt in child[x]:
        ret += leaf_count(nxt)
    return ret

n = int(input())
graph = list(map(int,input().split()))
child = defaultdict(list)
root = 0

for i in range(n):
    if graph[i] == -1:
        root = i
    child[graph[i]].append(i)

erase = int(input())
print(leaf_count(root))