import sys
input = sys.stdin.readline
from collections import defaultdict
from heapq import heappush, heappop

def calc_dis(i,j):
    dis = (((position[i][0]-position[j][0])**2) + ((position[i][1]-position[j][1])**2)) ** 0.5
    return dis

n,m = map(int,input().split())
position = []
path = set()
graph = defaultdict(list)
check = [False] * (n+1)

for _ in range(n):
    position.append(tuple(map(int,input().split())))
        
for _ in range(m):
    a,b = map(int,input().split())
    path.add((a,b))
    path.add((b,a))
    
for i in range(n-1):
    for j in range(i+1,n):
        if (i+1,j+1) in path:
            graph[i+1].append((j+1,0))
            graph[j+1].append((i+1,0))
        else:
            cost = calc_dis(i,j)
            graph[i+1].append((j+1,cost))
            graph[j+1].append((i+1,cost)) 

q = []
heappush(q,(0,1))

ans = 0
while q:
    cost,a = heappop(q)
    if check[a]:
        continue
    ans += cost
    check[a] = True
    for nxt,cost in graph[a]:
            heappush(q,(cost,nxt))
        
ans = round(ans,2)
print(f"{ans:.2f}")