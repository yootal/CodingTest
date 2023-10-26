t = int(input())
for case in range(1,t+1):
    d,h,m = map(int,input().split())
    standard = 11 + 60*11 + 24*60*11
    inp = m + 60*h + 24*60*d
    ans = inp - standard
    if ans < 0:
        print(f"#{case} -1")
    else:
        print(f"#{case} {ans}")