t  = int(input())
for case in range(1,t+1):
    n = int(input())
    v = 0
    ans = 0
    for i in range(1,n+1):
        inp = list(map(int,input().split()))
        if inp[0] == 1:
            v += inp[1]
        elif inp[0] == 2:
            v -= inp[1]
        if v < 0:
            v = 0
        ans += v
    print(f"#{case} {ans}")