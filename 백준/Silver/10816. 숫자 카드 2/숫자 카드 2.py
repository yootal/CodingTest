import sys

a = int(sys.stdin.readline())
b = list(map(int, sys.stdin.readline().split()))
dict = {}
b1 = list(set(b))
for b3 in b:
      if b3 in dict:
            dict[b3] += 1
      else: dict[b3] = 1
c = int(sys.stdin.readline())
d = list(map(int, sys.stdin.readline().split()))
for d1 in d:
      if d1 in dict:
            print(dict[d1],end=" ")
      else:
            print(0,end=" ")
