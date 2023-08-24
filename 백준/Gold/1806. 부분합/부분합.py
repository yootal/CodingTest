import sys
input = sys.stdin.readline

n,s = map(int,input().split())
num = list(map(int,input().split()))

ans = sys.maxsize
en = 0
total = num[0]
for st in range(n):
    if st > 0:
        total -= num[st - 1]
    while en < n - 1 and total < s:
        en += 1 
        total += num[en]
    if total >= s:
        ans = min(ans, en - st + 1)
    if st == n - 1:
        break
print(0 if ans == sys.maxsize else ans)