import sys
from collections import deque
input=sys.stdin.readline

n = int(input())

queue_list = deque([])

for _ in range(n):
      inp = input().strip()
      if inp == "pop_front":
            if len(queue_list)==0:
                  print(-1)
            else: print(queue_list.popleft())
      elif inp == "pop_back":
            if len(queue_list)==0:
                  print(-1)
            else: print(queue_list.pop())
      elif inp == "size":
            print(len(queue_list))
      elif inp == "empty":
            if len(queue_list)==0:
                  print(1)
            else: print(0)
      elif inp == "front":
            if len(queue_list)==0:
                  print(-1)
            else: print(queue_list[0])
      elif inp == "back":
            if len(queue_list)==0:
                  print(-1)
            else: print(queue_list[-1])
      else: 
            inp1, inp2 = inp.split()
            if inp1 == "push_front":
                  queue_list.appendleft(inp2)
            else:
                  queue_list.append(inp2)
