t = int(input())
for case in range(1,t+1):
    n = int(input())
    num = list(map(int,input().split()))
    ans = 0
    for i in range(n-1):
        for j in range(i+1,n):
            x = num[i] * num[j]
            if x <= ans:
                continue
            cur = x
            check = True
            while cur >= 10:
                last = cur % 10
                if cur // 10 % 10 > last:
                    check = False
                    break
                else:
                    cur //= 10
            if check:
                ans = max(ans,x)   
    if ans == 0:
        print(f"#{case} -1")   
    else:   
        print(f"#{case} {ans}")
    