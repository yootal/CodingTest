i = int(input())      
l = list(map(int,input().split(" ")))

if i % 2 == 0:
      print(min(l)*max(l))
else:
      if i == 1:
            print(pow(l[0],2))
      else: print(min(l)*max(l))