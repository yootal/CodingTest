from sys import stdin
input = stdin.readline

def solve(first, second, wc):
    global ans

    if wc == k:
        print(1)
        exit()
    
    if win_count[0] == k or win_count[1] == k:
        return

    if first != 1:
        result = info[inp[second - 2][idx[second-2]] - 1][inp[first - 2][idx[first-2]] - 1]
        nxt = 1
        if result == 0:
            win_count[first-2] += 1
            idx[first-2] += 1
            idx[second-2] += 1
            solve(nxt,first,wc)
            win_count[first-2] -= 1
            idx[first-2] -= 1
            idx[second-2] -= 1
        elif result == 1:
            idx[first-2] += 1
            idx[second-2] += 1
            if first > second:
                win_count[first-2] += 1
                solve(nxt,first,wc)
                win_count[first-2] -= 1
            else:
                win_count[second-2] += 1
                solve(nxt,second,wc)
                win_count[second-2] -= 1
            idx[first-2] -= 1
            idx[second-2] -= 1
        else:
            win_count[second-2] += 1
            idx[first-2] += 1
            idx[second-2] += 1
            solve(nxt,second,wc)
            win_count[second-2] -= 1
            idx[first-2] -= 1
            idx[second-2] -= 1
            
    else:
        for i in range(n):
            result = info[inp[second - 2][idx[second-2]] - 1][i]
            nxt = 6 - (first + second)
            if result == 0:
                if not vis[i]:
                    idx[second-2] += 1
                    vis[i] = True
                    solve(first, nxt, wc + 1)
                    vis[i] = False
                    idx[second-2] -= 1
            elif result == 1:
                if not vis[i]:
                    win_count[second-2] += 1 
                    idx[second-2] += 1
                    vis[i] = True
                    solve(second, nxt, wc)
                    vis[i] = False
                    win_count[second-2] -= 1
                    idx[second-2] -= 1
            else:
                if not vis[i]:
                    win_count[second-2] += 1
                    idx[second-2] += 1
                    vis[i] = True
                    solve(second, nxt, wc)
                    vis[i] = False
                    win_count[second-2] -= 1
                    idx[second-2] -= 1

n, k = map(int, input().split())
info = [tuple(map(int, input().split())) for _ in range(n)]
inp = [list(map(int, input().split())) for _ in range(2)]
ans = 0
vis = [False] * n
win_count = [0,0]
idx = [0,0]
solve(1, 2, 0)
print(ans)