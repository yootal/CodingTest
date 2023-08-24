import sys
input = sys.stdin.readline

def binary_search(target,start):
    global ans 
    st = start
    en = n - 1
    while st <= en:
        mid = (st + en) // 2
        gap = num[mid] - target
        if gap >= m:
            ans = min(ans,gap)
            en = mid - 1
        else:
            st = mid + 1
    return

n,m = map(int,input().split())
num = [int(input()) for _ in range(n)]
num.sort()

ans = sys.maxsize
for i in range(n-1):
    binary_search(num[i],i+1)    
print(ans)
