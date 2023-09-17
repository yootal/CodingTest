import sys
input = sys.stdin.readline

n,m = map(int,input().split())
use_check = [False] * (n+1)
arr = [0] * m

def bt(k):
    if k == m:
        print(*arr)
        return
    st = 1
    if k != 0:
        st = arr[k-1]
    for i in range(st,n+1):
        arr[k] = i
        bt(k+1)
        
bt(0)