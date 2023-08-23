import sys
input = sys.stdin.readline

n = int(input())
ability = list(map(int,input().split()))
ability.sort()

def lower_idx(target,start):
    st = start
    en = n
    
    while st < en:
        mid = (st + en) // 2
        if ability[mid] < target:
            st = mid + 1
        else:
            en = mid
    return st

def upper_idx(target,start):
    st = start
    en = n
    while st < en:
        mid = (st + en) // 2
        if ability[mid] <= target:
            st = mid + 1
        else:
            en = mid
    return st

ans = 0
for i in range(n-1):
    for j in range(i+1,n):
        right = upper_idx(-ability[i]-ability[j],j+1)
        left = lower_idx(-ability[i]-ability[j],j+1)
        ans += (right - left)
print(ans)

