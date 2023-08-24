import sys
input = sys.stdin.readline
    
n,m = map(int,input().split())
num = list(map(int,input().split()))

ans = 0
en = 0
total = num[0]
for st in range(n):
    if st > 0:
        total -= num[st - 1]
    while en < n - 1 and total < m:
        en += 1 
        total += num[en]
    if total == m:
        ans += 1
    if st == n - 1:
        break
    
print(ans)