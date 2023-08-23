import sys

n = int(sys.stdin.readline())
l = set(list(map(int, sys.stdin.readline().split())))
n2 = int(sys.stdin.readline())
l2 = list(map(int, sys.stdin.readline().split()))
result = map(lambda x:x in l,l2)
for i in result:
      print(int(i), end=" ")