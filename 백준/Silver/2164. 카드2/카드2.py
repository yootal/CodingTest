import sys
from collections import deque
input=sys.stdin.readline
n = int(input())
queue_list = deque([])
for i in range(1,n+1):
      queue_list.append(i)
while True:
      if len(queue_list)>1:
            queue_list.popleft()
      if len(queue_list) == 1:
            print(queue_list[0])
            break
      pop = queue_list.popleft()
      queue_list.append(pop)