from sys import stdin, maxsize
from collections import Counter
input = stdin.readline

n,m,b = map(int,input().split())
ground = Counter()
for _ in range(n):
    ground.update(map(int,input().split()))
    
ans_h = 0
ans_t = maxsize

for h in range(min(ground),max(ground)+1):
    have = b
    time = 0
    for height, cnt in ground.items():
        if height > h:
                time += (height - h) * 2 * cnt
                have += (height - h) * cnt    
        else:
            time += (h - height) * cnt
            have -= (h - height) * cnt
    if have >= 0:
        if time <= ans_t:
            ans_t = time
            ans_h = h         

print(ans_t,ans_h)
     