import sys
input=sys.stdin.readline
from collections import defaultdict

n = int(input())
vis = [True] + [False] * (n)
lc = defaultdict(int)
rc = defaultdict(int)
p = defaultdict(int)

for _ in range(n):
    m,l,r = map(int,input().split())
    lc[m] = l
    rc[m] = r 
    p[l] = m
    p[r] = m
            
endpoint = 1
while rc[endpoint] != -1:
    endpoint = rc[endpoint]
    
cur = 1    
cnt = 0
while True:
    vis[cur] = True
    cnt += 1
    if lc[cur] != -1 and not vis[lc[cur]]:
        cur = lc[cur]
    elif rc[cur] != -1 and not vis[rc[cur]]:
        cur = rc[cur]
    else:
        if cur == endpoint:
            break
        else:
            cur = p[cur]
            
print(cnt-1)
                