import sys
input=sys.stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]
board = []
for _ in range(5):
    board += list(map(str,input().strip()))
visited = [0 for _ in range(25)]
check = [[0] * 5 for _ in range(5)]

def permu(idx,route,position):
    global cnt,check
    if route.count('Y') > 3:
        return
    if idx == 7:
        if route.count('S') >= 4:
            position_check(position[0],position)
            if sum([sum(c) for c in check]) == 7:
                cnt += 1
            check = [[0] * 5 for _ in range(5)]
        return
    for i in range(25):
        if visited[i] == 0:
            visited[i] = 1
            permu(idx + 1, route + board[i], position + [i])
            for j in range(i+1,25):
                visited[j] = 0
                
def position_check(p,position):
    x = p // 5
    y = p % 5
    check[x][y] = 1
    for dx,dy in d:
        nx = x + dx
        ny = y + dy
        if 0 <= ny < 5 and 0 <= nx < 5:
            next = nx * 5 + ny
            if check[nx][ny] == 0 and next in position:
                check[nx][ny] = 1
                position_check(next,position)
            
cnt = 0
permu(0,'',[])
print(cnt)