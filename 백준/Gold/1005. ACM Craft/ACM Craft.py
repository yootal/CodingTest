import sys
input=sys.stdin.readline
from collections import defaultdict
from heapq import heappush, heappop

t = int(input())
for _ in range(t):
    n,k = map(int,input().split())
    need_time = list(map(int,input().split()))
    building = defaultdict(list)
    indegree = defaultdict(int)
    building_check = [False] * (n+1)
    
    for _ in range(1,k+1):
        s,e = map(int,input().split())
        indegree[e] += 1
        building[s].append(e)
    
    target = int(input())
        
    q = []
    for i in range(1,n+1):
        if indegree[i] == 0:
            heappush(q,(need_time[i-1],i))
    time = 0
    while True:
        while q and time == q[0][0]:
            building_time, building_num = heappop(q)
            building_check[building_num] = True
            for nxt in building[building_num]:
                indegree[nxt] -= 1
                if indegree[nxt] == 0:
                    heappush(q,(building_time + need_time[nxt-1],nxt))
        if building_check[target]:
            break
        time += 1
    print(time)
