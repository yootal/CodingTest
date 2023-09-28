import sys

q1,q2 = map(int, sys.stdin.readline().split())

dict = {}
l2 = []
for i in range(1,q1+1):
      input = sys.stdin.readline().rstrip()
      dict[i] = input
      dict[input] = i
for _ in range(q2):
      l2.append(sys.stdin.readline().rstrip())

for i2 in l2:
      if i2.isdigit():
            print(dict[int(i2)])
      else: print(dict[i2])

