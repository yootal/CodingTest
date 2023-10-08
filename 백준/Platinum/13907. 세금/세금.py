from sys import stdin,maxsize
from collections import defaultdict
from heapq import heappush, heappop
input = stdin.readline

def Dijkstra():
    sdt = [[maxsize] * (n) for _ in range(n+1)]
    sdt[s][0] = 0
    hq = []
    heappush(hq,(sdt[s][0],s,0))
    while hq:
        dis,cur,cnt = heappop(hq)
        check = False
        for i in range(1,cnt):
            if sdt[cur][i] < dis:
                check = True
                break
            # 사용한 수 보다 적은 수를 사용하고 값이 작으면 넘어감
        if check:
            continue
        cnt += 1
        for dis2,nxt in graph[cur]:
            if sdt[nxt][cnt] <= dis + dis2:
                continue
            sdt[nxt][cnt] = dis + dis2
            if cnt < n-1:
                heappush(hq,(dis + dis2,nxt,cnt))    
        
    return sdt[d]

n,m,k = map(int,input().split())
s,d = map(int,input().split())
graph = defaultdict(list)
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((c,b))
    graph[b].append((c,a))

dist = Dijkstra()

limit = 0
ans = maxsize
for i in range(1,n):
    if ans > dist[i]:
        ans = dist[i]
        limit = i
print(ans)    

rise = 0
for _ in range(k):
    rise += int(input())
    ans = maxsize
    for i in range(limit,0,-1):
        if ans > dist[i] + (i*rise):
            ans = dist[i] + (i*rise)
            limit = i
    print(ans)