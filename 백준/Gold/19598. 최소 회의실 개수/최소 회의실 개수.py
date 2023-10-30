from sys import stdin
from heapq import heappush, heappop
input = stdin.readline        

n  = int(input())
time = [tuple(map(int,input().split())) for _ in range(n)]
time.sort(key=lambda x:(-x[1],x[0]),reverse=True)

hq = []
ans = 0
while time:
    s,e = time.pop()
    if hq and -hq[0][0] >= e:
        heappop(hq)
        heappush(hq,(-s,e))
    else:
        ans += 1
        heappush(hq,(-s,e))
print(ans) 
