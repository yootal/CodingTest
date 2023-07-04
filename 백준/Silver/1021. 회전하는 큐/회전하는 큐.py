import sys
from collections import deque
input=sys.stdin.readline

r, n = map(int,input().split(" "))
loc = list(map(int,input().split(" ")))

queue_list = deque([])

for i in range(1,r+1):
      queue_list.append(i)
      
count = 0

for l in range(n):
      while True:
            if queue_list[0] == loc[l]:
                  queue_list.popleft()
                  break
            elif (len(queue_list)-1)-queue_list.index(loc[l])<queue_list.index(loc[l]):
                  count+=1
                  queue_list.appendleft(queue_list.pop())
            elif (len(queue_list)-1)-queue_list.index(loc[l])>=queue_list.index(loc[l]):
                  count+=1
                  queue_list.append(queue_list.popleft())
print(count)
      