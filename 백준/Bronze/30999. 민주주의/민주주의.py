n, m = map(int, input().split())
cnt = 0
for _ in range(n):
    if input().count("O") > m // 2:
        cnt += 1
print(cnt)