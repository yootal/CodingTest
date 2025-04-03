ans = 0
for _ in range(int(input())):
    p = int(input())
    a = p // 10
    b = p % 10
    ans += a ** b
print(ans)
