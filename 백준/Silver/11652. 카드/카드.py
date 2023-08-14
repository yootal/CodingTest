import sys
input = sys.stdin.readline

num = [int(input()) for _ in range(int(input()))]
num.sort()

cnt = 0
mxcnt = 0 
mxval = num[0]
check = num[0]

for i in range(len(num)):
    if num[i] == check:
        cnt += 1
        if cnt > mxcnt:
            mxcnt = cnt
            mxval = check
    else:
        cnt = 1
        check = num[i]
        
print(mxval)