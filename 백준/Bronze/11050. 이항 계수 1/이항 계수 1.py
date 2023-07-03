a,b = map(int,input().split(" "))
x = 1
for i in range(b):
      x*=(a-i)/(i+1)
print(int(x))
