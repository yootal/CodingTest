import sys
input=sys.stdin.readline
l = set()
count = 0
for _ in range(int(input().strip())):
      inp = input().strip()
      if inp == "ENTER":
            count+=len(l)
            l = set()
      else:
            l.add(inp)      
count+=len(l)
print(count)