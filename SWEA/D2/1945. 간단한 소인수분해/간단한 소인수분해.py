t  = int(input())
for case in range(1,t+1):
    cnt = {2:0,3:0,5:0,7:0,11:0}
    n = int(input())
    for x in cnt.keys():
        if n == 0:
            break
        while n % x == 0:
            cnt[x] += 1
            n //= x
    print(f"#{case}",end=" ")
    print(*cnt.values())