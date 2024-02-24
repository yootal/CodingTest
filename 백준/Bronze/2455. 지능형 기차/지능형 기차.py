ans = 0
train = 0
for _ in range(4):
    a,b = map(int,input().split())
    train += b-a
    ans = max(train,ans);
print(ans)