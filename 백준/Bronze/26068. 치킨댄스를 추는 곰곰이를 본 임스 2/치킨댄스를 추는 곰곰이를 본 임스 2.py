ans = 0
for _ in range(int(input())):
    time = int(input()[2:])
    if time <= 90:
        ans += 1
print(ans)