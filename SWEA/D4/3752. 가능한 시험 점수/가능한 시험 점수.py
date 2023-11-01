t = int(input())
for case in range(1, t + 1):
    n = int(input())
    score = list(map(int, input().split()))
    vis = [True] + [False] * sum(score)
    ans = [0]
    for s in score:
        for i in range(len(ans)):
            if not vis[s+ans[i]]:
                vis[s+ans[i]] = True
                ans.append(s+ans[i])
    print(f'#{case} {len(ans)}')