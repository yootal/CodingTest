from sys import stdin
input = stdin.readline

n = int(input())
a = [list(map(int, input().split())) for _ in range(n)]
select, check = [0 for _ in range(9)], [0 for _ in range(9)]
select[3], check[3] = 0, 1


def game():
    global ans
    cur, score = 0, 0
    for inning in a:
        out, b1, b2, b3 = 0, 0, 0, 0
        while out <= 2:
            r = inning[select[cur]]
            if r == 0:
                out += 1
            elif r == 1:
                score += b3
                b1, b2, b3 = 1, b1, b2
            elif r == 2:
                score += b2 + b3
                b1, b2, b3 = 0, 1, b1
            elif r == 3:
                score += b1 + b2 + b3
                b1, b2, b3 = 0, 0, 1
            else:
                score += b1 + b2 + b3 + 1
                b1, b2, b3 = 0, 0, 0
            cur += 1
            cur %= 9
    ans = max(ans, score)
    return


def solve(cnt):
    if cnt == 9:
        game()
    for i in range(9):
        if check[i]:
            continue
        check[i] = 1
        select[i] = cnt
        solve(cnt + 1)
        check[i] = 0
        select[i] = 0


ans = 0
solve(1)
print(ans)
