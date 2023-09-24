import math

a, b = map(int,input().split())

for i in range(a,b+1):
      count = 0
      for j in range(2, int(math.sqrt(i)+1)):
            if i%j == 0:
                  count+=1
                  break
      if count == 0 and i != 1:
            print(i)
      