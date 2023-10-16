from sys import stdin
from collections import defaultdict
input = stdin.readline

n = int(input())
m = int(input())
recommend = list(map(int,input().split()))
cnt = defaultdict(int)
frame = []

for i in range(m):
    if frame and recommend[i] in [x[0] for x in frame]:
        cnt[recommend[i]] += 1
    elif len(frame) < n:
        frame.append((recommend[i],i))
        cnt[recommend[i]] += 1
    else:
        frame.sort(key = lambda x: (cnt[x[0]],x[1]),reverse=True)
        cnt[frame[-1][0]] = 0
        frame.pop()
        frame.append((recommend[i],i))
        cnt[recommend[i]] += 1
    
frame.sort()
for x in frame:
    print(x[0],end=" ")
        