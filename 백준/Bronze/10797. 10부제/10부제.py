from sys import stdin
input = stdin.readline

n = int(input())
num = list(map(int,input().split()))

ans = 0
for x in num:
    if x == n:
        ans += 1
print(ans)