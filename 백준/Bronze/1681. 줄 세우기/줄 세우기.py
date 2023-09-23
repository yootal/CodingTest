import sys
input = sys.stdin.readline

n,l = map(int,input().split())
check = 0
l = str(l) 
num = 1
while True:
    if l not in list(str(num)):
        check += 1
        if check == n:
            print(num)
            break
    num += 1