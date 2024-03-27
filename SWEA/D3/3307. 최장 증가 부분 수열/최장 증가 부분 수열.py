from bisect import bisect_left

for t in range(1, int(input()) + 1):
    n = int(input())
    num = list(map(int, input().split()))
    ans = [0]
    for x in num:
        if ans[-1] < x:
            ans.append(x)
        else:
            ans[bisect_left(ans, x)] = x
    print(f'#{t} {len(ans)-1}')