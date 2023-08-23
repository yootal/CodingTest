import sys
input = sys.stdin.readline

n = int(input())
num = list(map(int,input().split()))
num.sort()
idx_check = [False] * n

def lower_idx(target):
    st = 0
    en = n
    while st < en:
        mid = (st + en) // 2
        if num[mid] < target:
            st = mid + 1
        else:
            en = mid
    return st

def upper_idx(target):
    st = 0
    en = n
    while st < en:
        mid = (st + en) // 2
        if num[mid] <= target:
            st = mid + 1
        else:
            en = mid
    return st

ans = 0
for i in range(n-1):
    for j in range(i+1,n):
        target = num[i] + num[j]
        left = lower_idx(target)
        right = upper_idx(target)
        for k in range(left,right):
                if k != i and k != j and not idx_check[k]:
                    idx_check[k] = True
                    ans += 1
print(ans)