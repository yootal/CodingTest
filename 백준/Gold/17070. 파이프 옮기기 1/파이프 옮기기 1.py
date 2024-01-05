from sys import stdin
input = stdin.readline

n = int(input())
state = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * (n) for _ in range(n)]
dp[0][1] = 1

stack = []
stack.append(((0, 0), (0, 1)))
while stack:
    pre, cur = stack.pop()
    # 가로
    if pre[0] == cur[0] and cur[1] - pre[1] == 1:
        if cur[1] + 1 < n and not state[cur[0]][cur[1] + 1]:
            dp[cur[0]][cur[1] + 1] += 1
            stack.append((cur, (cur[0], cur[1] + 1)))
        if cur[1] + 1 < n and cur[0] + 1 < n and not state[cur[0] + 1][cur[1] + 1] and not state[cur[0]][
            cur[1] + 1] and not state[cur[0] + 1][cur[1]]:
            dp[cur[0] + 1][cur[1] + 1] += 1
            stack.append((cur, (cur[0] + 1, cur[1] + 1)))
    # 세로
    elif pre[1] == cur[1] and cur[0] - pre[0] == 1:
        if cur[0] + 1 < n and not state[cur[0] + 1][cur[1]]:
            dp[cur[0] + 1][cur[1]] += 1
            stack.append((cur, (cur[0] + 1, cur[1])))
        if cur[0] + 1 < n and cur[1] + 1 < n and not state[cur[0] + 1][cur[1] + 1] and not state[cur[0]][
            cur[1] + 1] and not state[cur[0] + 1][cur[1]]:
            dp[cur[0] + 1][cur[1] + 1] += 1
            stack.append((cur, (cur[0] + 1, cur[1] + 1)))
    # 대각 
    else:
        if cur[0] + 1 < n and not state[cur[0] + 1][cur[1]]:
            dp[cur[0] + 1][cur[1]] += 1
            stack.append((cur, (cur[0] + 1, cur[1])))
        if cur[1] + 1 < n and not state[cur[0]][cur[1] + 1]:
            dp[cur[0]][cur[1] + 1] += 1
            stack.append((cur, (cur[0], cur[1] + 1)))
        if cur[0] + 1 < n and cur[1] + 1 < n and not state[cur[0] + 1][cur[1] + 1] and not state[cur[0]][
            cur[1] + 1] and not state[cur[0] + 1][cur[1]]:
            dp[cur[0] + 1][cur[1] + 1] += 1
            stack.append((cur, (cur[0] + 1, cur[1] + 1)))

print(dp[n - 1][n - 1])