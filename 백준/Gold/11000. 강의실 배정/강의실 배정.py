import sys
input = sys.stdin.readline
import heapq

n = int(input())
lecture = [tuple(map(int,input().split())) for _ in range(n)]
lecture.sort()

room = []
heapq.heappush(room,lecture[0][1])

for i in range(1,n):
    if lecture[i][0] < room[0]:
        heapq.heappush(room,lecture[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room,lecture[i][1])

print(len(room))