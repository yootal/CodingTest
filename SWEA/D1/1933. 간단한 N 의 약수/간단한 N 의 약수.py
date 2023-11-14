n = int(input())
ans = []
for i in range(1, int(n ** 0.5) + 1):
    if n % i == 0:
        ans.append(i)
for j in range(len(ans) - 1, -1, -1):
    if ans[j] ** 2 == n:
        continue
    ans.append(n // ans[j])
print(*ans)
