from collections import defaultdict

t = int(input())
for case in range(1, t + 1):
    idx = defaultdict(list)
    for _ in range(5):
        inp = list(input().rstrip())
        for i in range(len(inp)):
            idx[i].append(inp[i])
    ans = []
    for k in sorted(idx.keys()):
        for x in idx[k]:
            ans.append(x)
    ans = ''.join(ans)
    print(f'#{case} {ans}')
