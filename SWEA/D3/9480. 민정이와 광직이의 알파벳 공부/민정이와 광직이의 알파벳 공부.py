def count(st):
    global ans
    if 0 not in cnt:
        ans += 1
    for i in range(st, n):
        if not vis[i]:
            vis[i] = True
            for x in words[i]:
                if x.islower():
                    cnt[ord(x) - 97] += 1
            count(i + 1)
            vis[i] = False
            for x in words[i]:
                if x.islower():
                    cnt[ord(x) - 97] -= 1


t = int(input())
for case in range(1, t + 1):
    n = int(input())
    words = [list(input()) for _ in range(n)]
    vis = [False] * n
    cnt = [0] * 26
    ans = 0
    count(0)
    print(f'#{case} {ans}')