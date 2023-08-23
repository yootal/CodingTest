import sys
input = sys.stdin.readline

def binary_search(target):
    st = 0
    en = n2 - 1
    
    while st <= en:
        mid = (st + en) // 2
        if num2[mid] < target:
            st = mid + 1
        elif num2[mid] > target:
            en = mid - 1
        else:
            return True
    return False

n1, n2 = map(int,input().split())
num1 = list(map(int,input().split()))
num2 = list(map(int,input().split()))
num1.sort()
num2.sort()

cnt = 0
ans = []
for v in num1:
    if not binary_search(v):
        cnt += 1
        ans.append(v)
if cnt == 0:
    print(cnt)
else:
    print(cnt)  
    print(*ans)
