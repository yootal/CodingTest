import sys
from heapq import heappush, heappop
input = sys.stdin.readline

for _ in range(int(input())):
    hq = []
    n = int(input())
    for num in list(map(int,input().split())):
        heappush(hq,num)
    
    ans = 0
    for _ in range(n-1):
        combine = heappop(hq) + heappop(hq)
        ans += combine
        heappush(hq,combine)
        
    print(ans)