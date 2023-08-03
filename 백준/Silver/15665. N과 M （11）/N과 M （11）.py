import sys
input=sys.stdin.readline

def dfs():
    if len(temp) == m:
        print(*temp)
        return
    remember = 0
    for i in range(n):
        if remember != num_list[i]:
                visited[i] = True
                temp.append(num_list[i])
                remember = num_list[i]
                dfs()
                visited[i] = False
                temp.pop()

n,m = map(int,input().split())
num_list = sorted(list(map(int,input().split())))
visited = [False] * n
temp = []
dfs()
