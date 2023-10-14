n = int(input())
f = int(input())
a = n // 100
ans = a * 100

while ans % f != 0:
    ans += 1

print(str(ans)[-2:])
    