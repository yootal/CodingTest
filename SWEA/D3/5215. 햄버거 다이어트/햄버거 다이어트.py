def dfs(i, s, k):
    global ans
    if k > L:
        return
    if ans < s:
        ans = s
    if i == N:
        return
    score, kcal = data[i]
    dfs(i + 1, s + score, k + kcal)
    dfs(i + 1, s, k)


t = int(input())
for case in range(1, t + 1):
    N, L = map(int, input().split())
    data = [tuple(map(int, input().split())) for _ in range(N)]
    ans = 0
    dfs(0, 0, 0)
    print(f"#{case} {ans}")
