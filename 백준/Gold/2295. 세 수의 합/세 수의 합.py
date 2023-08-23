import sys
input = sys.stdin.readline

def binary_search(value,target,len):
    st = 0
    en = len - 1
    while st <= en:
        mid = (st + en) // 2
        if num2[mid] > target:
            en = mid - 1
        elif num2[mid] < target:
            st = mid + 1
        else:
            return value
    return 0

n = int(input())
num = [int(input()) for _ in range(n)]
num.sort()

num2 = []
for i in range(n):
    for j in range(i,n):
        num2.append(num[i] + num[j])
num2.sort()

ans = 0
for i in range(n-1,-1,-1):
    for j in range(i):
       ans = max(ans,binary_search(num[i] ,num[i] - num[j],len(num2))) 
       
print(ans)
