a,b = map(int,input().split())
ans = 1
while a < b:
    if b % 2 == 0:
        ans += 1
        b //= 2
    elif b % 10 == 1:
        ans += 1
        b //= 10
    else:
        break
        
if b == a:
    print(ans)
else:
    print(-1) 