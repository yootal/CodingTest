from heapq import heappush, heappop

for case in range(1,11):
    n = int(input())
    height = list(map(int,input().split()))
    max_hq = []
    min_hq = []
    for v in height:
        heappush(max_hq,-v)
        heappush(min_hq,v)
    for _ in range(n):
        if -max_hq[0] - min_hq[0] <= 1:
            break
        _max = heappop(max_hq)
        _min = heappop(min_hq)
        heappush(max_hq,_max+1)
        heappush(min_hq,_min+1)  
    ans = -max_hq[0] - min_hq[0]      
    print(f"#{case} {ans}")