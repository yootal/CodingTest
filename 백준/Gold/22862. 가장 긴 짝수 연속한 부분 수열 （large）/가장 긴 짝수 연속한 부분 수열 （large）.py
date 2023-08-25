import sys
input = sys.stdin.readline
    
n,k = map(int,input().split())
num = list(map(int,input().split()))

ans = 0
cnt = 0
en = 0
for st in range(n):
    while en < n and cnt <= k:
        if cnt >= k and num[en] % 2 == 1:
            break
        if num[en] % 2 == 1:
            cnt += 1
        en += 1 
    ans = max(ans, en - st - cnt)
    if num[st] % 2 == 1:
        cnt -= 1
    
print(ans)