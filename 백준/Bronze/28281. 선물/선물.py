n, x = map(int, input().split())
inp = list(map(int, input().split()))
ans = (inp[0] + inp[1]) * x
for i in range(1, n - 1):
    ans = min(ans, (inp[i] + inp[i + 1]) * x)
print(ans)