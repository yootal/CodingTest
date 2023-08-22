import sys
input = sys.stdin.readline
import heapq

n = int(input())
lines = [tuple(map(int,input().split())) for _ in range(n)]
lines.sort()

line = []
left = lines[0][0]
right = lines[0][1]
ans = 0

for i in range(1,n):
    if right >= lines[i][1]:
        continue
    elif lines[i][0] <= right < lines[i][1]:
        right = lines[i][1]
    elif right < lines[i][0]:
        ans += right - left
        left = lines[i][0]
        right = lines[i][1]
        
ans += right - left
print(ans)        