from collections import deque
import sys
input = sys.stdin.readline

n,l = map(int,input().split())
num_list = list(map(int,input().split()))

d = deque()

for i in range(n):
    while d and d[-1][0] > num_list[i]:
        d.pop()
    while d and d[0][1] < i - l + 1:
        d.popleft()
        
    d.append((num_list[i],i))
    
    print(d[0][0], end=" ")