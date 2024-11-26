n = int(input())
l1 = list(map(int, input().split()))
l2 = list(map(int, input().split()))
ans = 0
for idx in range(n):
    if l1[idx] <= l2[idx]:
        ans += 1
print(ans)