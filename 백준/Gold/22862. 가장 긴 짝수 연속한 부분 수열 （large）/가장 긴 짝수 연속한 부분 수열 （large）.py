import sys
input = sys.stdin.readline

n,k = map(int,input().split())
s = list(map(int,input().split()))

en = 0
ans = 0
if s[0] % 2 == 1:
    k -= 1
    len = 0
else:
    len = 1
    
for st in range(n):
    while en + 1 < n and (s[en+1] % 2 == 0 or k > 0):
        en += 1
        if s[en] % 2 == 0:
            len += 1
        else:
            k -= 1
    
    ans = max(ans,len)
    if en == n - 1:
        break

    if s[st] % 2 == 0:
        len -= 1
    else:
        k += 1

print(ans)
            