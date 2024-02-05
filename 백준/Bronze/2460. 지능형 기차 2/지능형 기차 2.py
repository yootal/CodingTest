from sys import maxsize

total = 0
ans = -maxsize
for _ in range(10):
    a,b = map(int,input().split())
    total -= a
    total += b
    ans = max(ans,total)
print(ans)