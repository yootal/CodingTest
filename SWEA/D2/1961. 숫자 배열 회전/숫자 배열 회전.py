t  = int(input())
for case in range(1,t+1):
    n = int(input())
    matrix = [list(input().rstrip().split()) for _ in range(n)]
    ans = [[] for _ in range(n)]
    
    for i in range(n):
        num = ""
        for j in range(n-1,-1,-1):
            num += matrix[j][i]
        ans[0].append(num)
    
    for i in range(n-1,-1,-1):
        num = ""
        for j in range(n-1,-1,-1):
            num += matrix[i][j]
        ans[1].append(num)
    
    for i in range(n-1,-1,-1):
        num = ""
        for j in range(n):
            num += matrix[j][i]
        ans[2].append(num)
        
    print(f"#{case}")
    for i in range(n):
        print(ans[0][i],ans[1][i],ans[2][i])