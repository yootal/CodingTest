import sys, heapq
input=sys.stdin.readline

n = int(input())

heap = []

for i in range(n):
    inp = int(input())
    if inp == 0:
        if len(heap) == 0:
            print(0)
        else:
            print(heapq.heappop(heap))
    else:
        heapq.heappush(heap,inp)


