n = int(input())
num = list(map(int, input().split()))
cnt = 0
for x in num:
    if x % 2 == 0:
        cnt += 1
print("Happy" if cnt > n / 2 else "Sad")