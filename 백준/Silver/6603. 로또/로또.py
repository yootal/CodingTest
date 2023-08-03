import sys
input=sys.stdin.readline

def dfs():
    if len(temp) == 6:
        print(*temp)
        return
    for i in range(1,n+1):
            if len(temp) > 0 and temp[-1] < num_list[i] or not temp:
                # visited[i] = True
                temp.append(num_list[i])
                dfs()
                # visited[i] = False
                temp.pop()

while True:
    inp = input().rstrip()
    if inp == '0':
        break
    else:
        num_list = list(map(int,inp.split()))
        temp = []
        n = num_list[0]
        # visited = [False] * (n+1)
        dfs()
        print()

