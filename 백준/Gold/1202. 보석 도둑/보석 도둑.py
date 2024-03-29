import sys, heapq
input = sys.stdin.readline

n,k = map(int,input().split())
jewel = []
bag = []
for _ in range(n):
    heapq.heappush(jewel,tuple(map(int,input().split())))
for _ in range(k):
    bag.append(int(input()))
bag.sort()

total = 0
temp_jewel = []
for size in bag:
    while jewel and size >= jewel[0][0]:
        # 가방 사이즈보다 작은 보석 temp에 넣고 temp 중 가장 가치 높은 보석 선택
        heapq.heappush(temp_jewel, -heapq.heappop(jewel)[1])
    if temp_jewel:
        total -= heapq.heappop(temp_jewel)
    elif not jewel:
        break

print(total)