import sys
input = sys.stdin.readline

n,m = map(int,input().split())
use_check = [False] * (n+1)
arr = [0] * m

def bt(k):
    if k == m:
        print(*arr)
        return
    for i in range(1,n+1):
        arr[k] = i
        bt(k+1)
        
bt(0)