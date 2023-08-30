import sys
input=sys.stdin.readline
from collections import defaultdict, deque

n = int(input())
friend = defaultdict(list)  
vis = [False] * n
score = [0] * n

while True:
    s,e = map(int,input().split())
    if s == -1 and e == -1:
        break
    friend[s].append(e)
    friend[e].append(s)
    
def bfs(i):
    vis[i-1] = True
    q = deque([(i,1)])
    cnt = 1
    while q:
        pq,depth = q.popleft()
        for f in friend[pq]:
            if not vis[f-1]:
                vis[f-1] = True
                cnt += 1
                if cnt == n:
                    return depth
                q.append((f,depth + 1))
            
for i in range(1,n+1):
    score[i-1] = bfs(i)
    vis = [False] * n

print(min(score),score.count(min(score)))
for i in range(n):
    if score[i] == min(score):
        print(i+1, end = " ")
     