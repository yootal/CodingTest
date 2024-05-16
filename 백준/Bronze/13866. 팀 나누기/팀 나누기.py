from sys import stdin

input = stdin.readline
num = list(map(int, input().split()))
total = sum(num)
ans = total
for i in range(4):
    for j in range(i + 1, 4):
        cur = num[i] + num[j]
        ans = min(ans, abs(cur - (total - cur)))
print(ans)