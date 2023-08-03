import sys
input=sys.stdin.readline

def n_queen(cur):
    global count
    if cur == n:
        count += 1
        return
    for i in range(0,n):
        if check1[i] or check2[i+cur] or check3[cur-i+n+1]:
            continue
        check1[i] = True
        check2[i+cur] = True
        check3[cur-i+n+1] = True
        n_queen(cur + 1)
        check1[i] = False
        check2[i+cur] = False
        check3[cur-i+n+1] = False


n = int(input())
count = 0
check1 = [False]*30
check2 = [False]*30
check3 = [False]*30
n_queen(0)
print(count)