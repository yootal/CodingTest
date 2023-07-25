from collections import deque
import sys
sys.setrecursionlimit(10**9)
input=sys.stdin.readline

n,k = map(int,input().split())
visited = [0]*100001
d = [-1,1,0]

def bfs(v):
    q = deque([v])
    visited[v] = 1
    while q:
        loc = q.popleft()
        if loc == k:
            print(visited[k]-1)
            return
        for i in range(3):
            if i == 2:
                loc2 = loc*2
                if loc2 >= 100001:
                    continue
                if visited[loc2] == 0:
                    visited[loc2] = visited[loc] + 1
                    q.append(loc2)
            else:
                loc2 = loc + d[i]
                if loc2 < 0 or loc2 >= 100001:
                    continue
                elif visited[loc2] == 0:
                    visited[loc2] = visited[loc] + 1
                    q.append(loc2)
bfs(n)