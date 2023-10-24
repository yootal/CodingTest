t = int(input())
for case in range(1,t+1):
    n = int(input())
    limit = []
    for _ in range(n):
        a,b = map(int,input().split())
        limit.append((a,b))
    p = int(input())
    ans = []
    for _ in range(p):
        result = 0
        point = int(input())
        for a,b in limit:
            if a <= point <= b:
                result += 1
        ans.append(result)
    print(f"#{case}",end=" ")
    print(*ans)
    