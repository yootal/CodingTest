import sys
input=sys.stdin.readline

input_list = []
for _ in range(int(input())):
      input_list.append(input().strip())
      
for i1 in input_list:
      stack_check = []
      for i2 in i1:
            if i2 == "(":
                  stack_check.append(0)
            else:
                  if len(stack_check) == 0:
                        stack_check.append(-1)
                        break
                  else:
                        stack_check.pop()
      if len(stack_check)==0:
            print("YES")
      else: print("NO")