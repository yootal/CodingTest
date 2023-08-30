import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n,m = map(int,input().split())
computer = defaultdict(list)  
vis = [False] * n
score = [0] * n

for _ in range(m):
    e,s = map(int,input().split())
    computer[s].append(e)
            
def bfs(i):
    global cnt
    q = deque([i])
    vis[i-1] = True            
    while q:
        pq = q.popleft()
        for c in computer[pq]:
            if not vis[c-1]:
                cnt += 1
                vis[c-1] = True
                q.append(c)
        
for i in range(1,n+1):
    cnt = 1
    bfs(i)
    score[i-1] = cnt
    vis = [False] * n

ms = max(score)
for i in range(n):
    if score[i] == ms:
        print(i+1, end=" ")
     
    



