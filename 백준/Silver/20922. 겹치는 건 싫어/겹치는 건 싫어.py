import sys
input = sys.stdin.readline
    
n,k = map(int,input().split())
num = list(map(int,input().split()))
num_count = [0] * 100001

en = 0
cnt = 0
ans = 0
for st in range(n):
    while en < n and num_count[num[en]] < k:
        num_count[num[en]] += 1
        en += 1
    ans = max(ans,en-st)
    num_count[num[st]] -= 1
print(ans)