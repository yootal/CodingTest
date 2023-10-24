t = int(input())
for case in range(1,t+1):
    n = int(input())
    card = list(input().rstrip().split())
    flag = n // 2
    ans = []
    if n % 2 == 1:
        flag += 1
    for i in range(flag):
        ans.append(card[i])
        if i + flag < n:
            ans.append(card[i+flag])
    print(f"#{case}",end=" ")
    print(*ans)
    