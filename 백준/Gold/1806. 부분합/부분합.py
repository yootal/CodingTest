import sys
input = sys.stdin.readline

n,s = map(int,input().split())
num = list(map(int,input().split()))

ans = sys.maxsize
total = num[0]
en = 0
for st in range(n):
    while en < n and total < s:
        en += 1
        if en != n:
            total += num[en]
    if en == n:
        break
    ans = min(ans,en-st+1) 
    total -= num[st]
        
print(0 if ans == sys.maxsize else ans) 
    