import sys
input = sys.stdin.readline

n,l = map(int,input().split())
leak = list(map(int,input().split()))
leak.sort()

repair = 0
ans = 0
for i in range(n):
    if leak[i] > repair:
        ans += 1
        repair = leak[i] + l - 1
    else:
        continue

print(ans)
        