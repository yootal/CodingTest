import sys
from collections import deque   
input = sys.stdin.readline

for _ in range(int(input())):
    f = input() 
    n = int(input()) 
    l = input() 

    d = deque (map(str,(eval(l))))

    check = True
    r_check = False
    for f2 in f:
        if f2 =="R":
            r_check = not r_check
        elif f2 == "D":
            if r_check == False:
                if n>0:
                    d.popleft()
                    n-=1
                else: 
                    print("error")
                    check = False
                    break
            else:
                if n>0:
                    d.pop()
                    n-=1
                else: 
                    print("error")
                    check = False
                    break
    if check == True:
        if r_check == False:
            print("[",end="")
            print(",".join(d),end="")
            print("]")
        else:
            print("[",end="")
            print(",".join(reversed(d)),end="")
            print("]")   
    