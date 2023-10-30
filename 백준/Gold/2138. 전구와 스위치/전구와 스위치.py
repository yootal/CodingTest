from sys import stdin, maxsize
input = stdin.readline        

n = int(input())
before = list(map(int,input().rstrip()))
after = list(map(int,input().rstrip()))

def change(a,b):
    temp = a[:]
    cnt = 0
    for i in range(1,n):
        if temp[i-1] == b[i-1]:
            continue
        cnt += 1
        for j in range(i-1,i+2):
            if j < n:
                temp[j] = 1 - temp[j]
    return cnt if temp == b else maxsize

# 처음 스위치 안누르고
ans = change(before,after)

# 처음 스위치 누르고
before[0] = 1 - before[0]
before[1] = 1 - before[1]
ans = min(ans,change(before,after) + 1)

print(ans if ans != maxsize else -1) 