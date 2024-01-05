from sys import stdin,maxsize
from collections import deque
input = stdin.readline

n,k = map(int,input().split())
dq = deque([(n,0)])
vis = [maxsize] * 100001
ans = -1
ans_cnt = 0

while dq:
    p,cnt = dq.popleft()
    if vis[p] == maxsize:
        vis[p] = cnt
    if p == k:
        if ans == -1:
            ans = cnt
            ans_cnt += 1
            continue
        if ans == cnt:
            ans_cnt += 1
        else:
            break
    for i in range(3):
        if i == 0:
            np = p + 1
            if 0 <= np <= 100000:
                if vis[p] + 1 <= vis[np]:
                    dq.append((np,cnt+1))
        elif i == 1:
            np = p - 1
            if 0 <= np <= 100000:
                if vis[p] + 1 <= vis[np]:
                    dq.append((np,cnt+1))
        else:
            np = p * 2
            if 0 <= np <= 100000:
                if vis[p] + 1 <= vis[np]:
                    dq.append((np,cnt+1))
print(ans)
print(ans_cnt)