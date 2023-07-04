import sys
from collections import deque
input=sys.stdin.readline
a,b = map(int,input().split(" "))
queue_list = deque([])
result_list = []
for i in range(1,a+1):
      queue_list.append(i)
while True:
      if len(queue_list)>1:
            for _ in range(b-1):
                  queue_list.append(queue_list.popleft())
      result_list.append(str(queue_list.popleft()))
      if len(queue_list) == 0:
            break
print("<",end="")
print(", ".join(result_list),end="")
print(">")
