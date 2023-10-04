import sys
input=sys.stdin.readline

dy,dx = [-1,1,0,0],[0,0,-1,1]

cnt = 0
board = []
for _ in range(5):
    board += list(map(str,input().strip()))
visited = [0 for _ in range(25)]
check = [[0] * 5 for _ in range(5)]

def permu(idx,ans,position):
    global cnt,check
    if ans.count('Y') > 3:
        return
    if idx == 7:
        if ans.count('S') >= 4:
            position_check(position[0],position)
            if sum(sum(check,[])) == 7:
                cnt += 1
            check = [[0] * 5 for _ in range(5)]
        return
    for i in range(25):
        if visited[i] == 0:
            visited[i] = 1
            permu(idx + 1, ans + board[i], position + [i])
            for j in range(i+1,25):
                visited[j] = 0
                
def position_check(s,position):
    r = s // 5
    c = s % 5
    check[r][c] = 1
    for j in range(4):
        ny = r + dy[j]
        nx = c + dx[j]
        if 0 <= ny < 5 and 0 <= nx < 5:
            next = ny * 5 + nx
            if check[ny][nx] == 0 and next in position:
                check[ny][nx] = 1
                position_check(next,position)
            
permu(0,'',[])
print(cnt)