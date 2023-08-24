import sys
input = sys.stdin.readline

t = int(input())
n = int(input())
num = list(map(int,input().split()))
m = int(input())
num2 = list(map(int,input().split()))

seg_num = []
seg_num2 =[]

for i in range(n):
    seg = 0
    for j in range(i,n):
        seg += num[j]
        seg_num.append(seg)
        
for i in range(m):
    seg = 0
    for j in range(i,m):
        seg += num2[j]
        seg_num2.append(seg)
        
seg_num.sort()
seg_num2.sort()
seg_num2_len = len(seg_num2)

def lower_idx(target):
    st = 0
    en = seg_num2_len
    while st < en:
        mid = (st + en) // 2
        if seg_num2[mid] < target:
            st = mid + 1
        else:
            en = mid
    return st

def upper_idx(target):
    st = 0
    en = seg_num2_len
    while st < en:
        mid = (st + en) // 2
        if seg_num2[mid] <= target:
            st = mid + 1
        else:
            en = mid
    return st

ans = 0 
for i in range(len(seg_num)):
    left = lower_idx(t-seg_num[i])
    right = upper_idx(t-seg_num[i])
    ans += (right - left)
    
print(ans)
