import sys
input = sys.stdin.readline

def lower_idx(target,check):
    if check:
        st = 0
        en = n*n
        while st < en:
            mid = (st + en) // 2
            if a_b[mid] >= target:
                en = mid
            else:
                st = mid + 1   
    else:
        st = -1
        en = n*n - 1 
        while st < en:
            mid = (st + en + 1) // 2
            if c_d[mid] < target:
                st = mid
            else:
                en = mid - 1
    return st

def upper_idx(target,check):
    if check:
        st = 0
        en = n*n
        while st < en:
            mid = (st + en) // 2
            if a_b[mid] > target:
                en = mid
            else:
                st = mid + 1   
    else:
        st = -1
        en = n*n - 1 
        while st < en:
            mid = (st + en + 1) // 2
            if c_d[mid] <= target:
                st = mid
            else:
                en = mid - 1
    return st

n = int(input())
arr = []
a_b = []
c_d = []

for _ in range(n):
    arr.append(tuple(map(int,input().split())))

for i in range(n):
    for j in range(n):
        a_b.append(arr[i][0] + arr[j][1])
        c_d.append(arr[i][2] + arr[j][3])     
a_b.sort()
c_d.sort()

ans = 0
st, en = 0, n*n - 1
while 0 <= en and st < n*n:
    sum = a_b[st] + c_d[en]
    if sum < 0:
        st += 1
    elif sum > 0:
        en -= 1
    else:
        a_b_upper = upper_idx(a_b[st],True)
        a_b_lower = lower_idx(a_b[st],True)
        c_d_upper = upper_idx(c_d[en],False)
        c_d_lower = lower_idx(c_d[en],False)
        ans += (a_b_upper - a_b_lower) * (c_d_upper - c_d_lower)
        st = a_b_upper
        en = c_d_lower

print(ans)