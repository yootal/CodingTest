t  = int(input())
for case in range(1,t+1):
    num = list(map(int,input().split()))
    num.sort()
    ans = sum(num[1:-1]) / (len(num)-2)
    print(f"#{case} {round(ans)}")