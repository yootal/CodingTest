t = int(input())
for case in range(1, t + 1):
    n = int(input())
    score = list(map(int, input().split()))
    ans = [0]
    for s in score:
        ans = list(set(ans))
        for i in range(len(ans)):
            ans.append(ans[i]+s)
    print(f'#{case} {len(set(ans))}')
