l = []
for _ in range(int(input())):
      l.append(list(map(int,input().split(" "))))

for l1 in l:
      x = 1
      y = 1
      for i in range(l1[0]):
          x*=(l1[1]-i)
          y*=(i+1)
      print(x//y)

