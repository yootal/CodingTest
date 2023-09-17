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
    for i in range(n):
        if not use_check[i]:
            use_check[i] = True
            arr[k] = num[i] 
            bt(k+1)
            use_check[i] = False        
bt(0)