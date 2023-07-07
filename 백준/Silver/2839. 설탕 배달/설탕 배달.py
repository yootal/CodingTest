import sys

a = int(input())
min_v = sys.maxsize
check = False
for i in range(0,a//5+1):
    a2 = a - (i*5)
    if a2%3 == 0:
        check = True
        min_v = min(min_v,i+(a2//3))
if check == True: print(min_v)
else: print(-1)
    