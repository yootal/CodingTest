n,k = map(int,input().split())
y_cnt = [[0] * 2 for _ in range(6)]

for _ in range(n):
    s,y = map(int,input().split())
    y_cnt[y-1][s] += 1

ans = 0
for cnt in y_cnt:
    ans += (cnt[0] // 2)
    if cnt[0] % 2 > 0:
        ans += 1
    ans += (cnt[1] // 2)
    if cnt[1] % 2 > 0:
        ans += 1
        
print(ans)
     