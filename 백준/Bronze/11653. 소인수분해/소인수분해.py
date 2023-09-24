a = int(input())

s = 2
while a != 1:
      if a % s == 0:
            a //= s
            print(s)
            s = 2
      else:
            s += 1