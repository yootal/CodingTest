t  = int(input())
for case in range(1,t+1):
    n = int(input())
    num = list(map(int,input().split()))
    print(f"#{case}",end=" ")
    print(*sorted(num))