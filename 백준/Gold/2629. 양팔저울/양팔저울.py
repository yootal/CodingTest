from sys import stdin
input = stdin.readline

n = int(input())
w = list(map(int, input().split()))
n2 = int(input())
w2 = list(map(int, input().split()))
max_weight = sum(w)

dp = [[False] * (max_weight + 1) for _ in range(n + 1)]

result = set()

def solve(pends, cnt, now, left, right):
    new = abs(left - right)
    if new not in result:
        result.add(new)
    if now == cnt:
        return
    if not dp[now][new]:
        solve(pends, cnt, now + 1, left + w[now], right)
        solve(pends, cnt, now + 1, left, right + w[now])
        solve(pends, cnt, now + 1, left, right)
        dp[now][new] = True

solve(w, n, 0, 0, 0)

for i in w2:
    if i in result:
        print('Y', end=' ')
    else:
        print('N', end=' ')