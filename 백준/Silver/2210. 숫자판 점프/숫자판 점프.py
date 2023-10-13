from sys import stdin
input = stdin.readline

d = [(-1,0),(1,0),(0,-1),(0,1)]

matrix = [list(input().rstrip().split()) for _ in range(5)]
ans_set = set()

def dfs(i,j,s,cnt):
    if cnt == 5:
        ans_set.add(''.join(s))
        return
    for dx,dy in d:
        nx = i + dx
        ny = j + dy
        if 0 <= nx < 5 and 0 <= ny < 5:
            s.append(matrix[nx][ny])
            dfs(nx,ny,s,cnt+1)
            s.pop()

for i in range(5):
    for j in range(5):
        dfs(i,j,[matrix[i][j]],0)

print(len(ans_set))