from sys import stdin,maxsize
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

def exclude(en,remain,ep,pr):
    if remain == 0:
        return
    for st in pr[(en,remain)]:
        if (st,en) in ep:
            continue
        ep.add((st,en))
        exclude(st,remain-dist[(st,en)],ep,pr)

def Dijkstra(s,d):
    # 최단 거리와 경로 찾기
    sdt = [maxsize] * (n+1)
    pre_route = defaultdict(set) 
    sdt[s] = 0
    hq = []
    heappush(hq,(sdt[s],s))
    while hq:
        dis,cur = heappop(hq)
        if sdt[cur] != dis:
            continue
        for dis2,nxt in graph[cur]:
            new_dis = sdt[cur] + dis2
            if sdt[nxt] > new_dis:
                sdt[nxt] = new_dis
                pre_route[(nxt,new_dis)].add(cur)
                heappush(hq,(sdt[nxt],nxt))
            if sdt[nxt] == new_dis:
                pre_route[(nxt,new_dis)].add(cur)
                
    ep = set() # 제외할 경로
    exclude(d,sdt[d],ep,pre_route)
    
    # 제외하고 다시 다익스트라
    sdt = [maxsize] * (n+1)
    sdt[s] = 0
    hq = []
    heappush(hq,(sdt[s],s))
    while hq:
        dis,cur = heappop(hq)
        if sdt[cur] != dis:
            continue
        for dis2,nxt in graph[cur]:
            if (cur,nxt) in ep:
                continue
            new_dis = sdt[cur] + dis2
            if sdt[nxt] > new_dis:
                sdt[nxt] = new_dis
                heappush(hq,(sdt[nxt],nxt))
                
    print(sdt[d] if sdt[d] != maxsize else -1)
                   
while True: 
    n,m = map(int,input().split())
    if n == 0 and m == 0:
        break
    s,d = map(int,input().split())
    graph = defaultdict(list)
    dist = defaultdict(int)
    for i in range(m):
        a,b,c = map(int,input().split())
        graph[a].append((c,b))
        dist[(a,b)] = c

    Dijkstra(s,d)
        