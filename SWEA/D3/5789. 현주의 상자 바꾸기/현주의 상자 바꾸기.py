t = int(input())
for case in range(1,t+1):
    n,q = map(int,input().split())
    box = [0] * n
    for c in range(1,q+1):
        l,r = map(int,input().split())    
        for i in range(l-1,r):
            box[i] = c
    print(f'#{case}',end=" ")
    print(*box)