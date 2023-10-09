from sys import stdin,maxsize
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

def Dijkstra(s):
    sdt = [maxsize] * (n+1)
    sdt[s] = 0
    hq = []
    heappush(hq,(sdt[s],s))
    
    while hq:
        cost,cur = heappop(hq)
        if sdt[cur] < cost:
            continue
        for nxt,cost2 in graph[cur]:
            if nxt in exclude:
                continue
            if sdt[nxt] > cost + cost2:
                sdt[nxt] = cost + cost2
                heappush(hq,(cost + cost2,nxt))
    
    return sdt

n,m = map(int,input().split())
graph = defaultdict(list)
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
    
for i in range(1,n+1):
    graph[i].sort()
        
st,en = map(int,input().split())
exclude = set()

en_to_st = Dijkstra(en)

first_dis = 0
cursor = st
while cursor != en:
    for nxt,nxt_cost in graph[cursor]:
        if first_dis + nxt_cost + en_to_st[nxt] == en_to_st[st]:
            first_dis += nxt_cost
            exclude.add(nxt)
            cursor = nxt
            break
        
exclude.remove(en)
st_to_en = Dijkstra(st)

print(en_to_st[st] + st_to_en[en])
