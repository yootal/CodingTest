import sys
from collections import deque
input=sys.stdin.readline
n = int(input())
queue_list = deque([])
for _ in range(n):
      i1 = input().rstrip()
      if i1 == "pop":
            if len(queue_list) == 0:
                  print(-1)
            else: 
                  print(queue_list.popleft())
      elif i1 == "size":
            print(len(queue_list))
      elif i1 == "empty":
            if len(queue_list)==0:
                  print(1)
            else: print(0)
      elif i1 == "front":
            if len(queue_list)==0:
                  print(-1)
            else: print(queue_list[0])
      elif i1 == "back":
            if len(queue_list)==0:
                  print(-1)
            else: print(queue_list[-1])
      else:
            i2 = i1.split(" ")
            queue_list.append(int(i2[1]))
      
                  





            
