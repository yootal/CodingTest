change = [50000,10000,5000,1000,500,100,50,10]
t  = int(input())
for case in range(1,t+1):
    n = int(input())
    cnt = [0,0,0,0,0,0,0,0]
    for i in range(8):
        if n >= change[i]:
            cnt[i] = n // change[i] 
            n %= change[i]
            if n == 0:
                break 
    print(f"#{case}")
    print(*cnt)