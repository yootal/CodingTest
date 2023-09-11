import sys
input=sys.stdin.readline

n = int(input())

input_list = []
stack_list=[]
result_list=[]

for _ in range(n):
      input_list.append(int(input()))

index = 0      
for i1 in input_list:
      if index == 0:
            for i in range(1,i1+1):
                  stack_list.append(i)
                  result_list.append("+")
            index = i1
            stack_list.pop()
            result_list.append("-")
 
      elif i1 < index:
            pop = stack_list.pop()
            result_list.append("-")
            if i1 != pop:
                  print("NO")
                  break
              
      elif i1 > index:
            for i in range(index+1,i1+1):
                  stack_list.append(i)
                  result_list.append("+") 
            index = i1
            stack_list.pop()
            result_list.append("-")  
            
if len(stack_list) == 0:
      for r in result_list:
            print(r)