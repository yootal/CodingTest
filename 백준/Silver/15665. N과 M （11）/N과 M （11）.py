import sys
input = sys.stdin.readline

n,m = map(int,input().split())
num = list(map(int,input().split()))
num.sort()
use_check = [False] * (n)
arr = [0] * m

def bt(k):
    if k == m:
        print(*arr)
        return
    temp = 0
    for i in range(n):
        if not use_check[i] and temp != num[i]:
            arr[k] = num[i]
            temp = arr[k] 
            bt(k+1)
                  
bt(0)