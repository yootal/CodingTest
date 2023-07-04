import sys
from collections import deque
input=sys.stdin.readline

n = int(input())
result_list = []

for _ in range(n):
      range,location = map(int,input().split(" "))
      queue_list = deque(list(map(int,input().split(" "))))
      location_list = deque([0]*range)
      max_q = max(queue_list)
      location_list[location] = 1
      count = 0
      while True:
            pop = queue_list.popleft()
            pop2 = location_list.popleft()
            if pop == max_q:
                  if pop2 == 1:
                        count +=1
                        result_list.append(count)
                        break
                  else: 
                        max_q = max(queue_list)
                        count +=1
            else: 
                  queue_list.append(pop)
                  location_list.append(pop2)
for r in result_list:      
      print(r)

