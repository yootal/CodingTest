import sys
input=sys.stdin.readline

input_list = []
stack_list = []
for _ in range(int(input())):
      input_list.append(input().strip())
for inp in input_list:
      if inp == "pop":
            if len(stack_list) == 0:
                  print(-1)
            else:
                  print(stack_list.pop())
      elif inp == "size":
            print(len(stack_list))
      elif inp == "empty":
            if len(stack_list) == 0:
                  print(1)
            else:
                  print(0)
      elif inp == "top":
            if len(stack_list) == 0:
                  print(-1)
            else:
                  print(stack_list[len(stack_list)-1])
      else:
           i,v = inp.split() 
           stack_list.append(v)

            
