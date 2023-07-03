import sys
input=sys.stdin.readline

input_list = []
while True:
      inp = input().rstrip()
      if inp==".":
            break
      else: 
            input_list.append(inp)
for inp in input_list:
      input_list1 = []
      for i1 in inp:
            if i1 == "[":
                  input_list1.append("[")
            elif i1 == "(":
                  input_list1.append("(")
            elif i1 == ")":
                  if len(input_list1) == 0:
                        input_list1.append(-1)
                        break
                  else:
                        pop = input_list1.pop()
                        if pop != "(":
                              input_list1.append(-1)
                              break
            elif i1 == "]":
                  if len(input_list1) == 0:
                        input_list1.append(-1)
                        break
                  else:
                        pop = input_list1.pop()
                        if pop != "[":
                              input_list1.append(-1)
                              break
      if len(input_list1)==0:
            print("yes")
      else: print("no")


            
