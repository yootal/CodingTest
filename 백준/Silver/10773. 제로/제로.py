import sys
input=sys.stdin.readline

input_list = []
for _ in range(int(input())):
      inp = int(input())
      if inp == 0:
            input_list.pop()
      else:
            input_list.append(inp)
print(sum(input_list))