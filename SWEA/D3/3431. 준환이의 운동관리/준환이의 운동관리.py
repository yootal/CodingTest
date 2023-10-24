t = int(input())
for case in range(1,t+1):
    l,u,x = map(int,input().split())
    if l <= x <= u:
         print(f"#{case} 0")
    elif x > u: 
        print(f"#{case} -1")
    elif x < l:
        print(f"#{case} {l-x}")
    