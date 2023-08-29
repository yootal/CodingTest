import sys
from heapq import heappop, heappush
input = sys.stdin.readline

n = int(input())
h1 = []
h2 = []
for _ in range(n):
    inp = int(input())
    
    if len(h2) == 0:
        heappush(h2,inp)
    elif h2 and inp < h2[0]:
        heappush(h1,-inp)
    elif h2 and inp >= h2[0]:
        heappush(h2,inp)

    # 1번 큐 크기가 더 커지면
    if len(h1) > len(h2):
        heappush(h2,-heappop(h1))

    # 2번 큐가 너무 커지면        
    if len(h1) == (len(h2) - 2):
        heappush(h1,-heappop(h2))    
        
    if len(h1) == len(h2):
        print(-h1[0])
        # print("### ",-h1[0])
        # print(h1)
        # print(h2)
        # print()
    else:
        print(h2[0])
        # print("### ",h2[0])    
        # print(h1)
        # print(h2)
        # print()
    