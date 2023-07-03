a = int(input())
if a == 0 or a == 1:
      print(1)
else:
      x = 1
      for n in range(1,a+1):
            x*=n
      print(x)
