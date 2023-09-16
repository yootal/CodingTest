import sys
input = sys.stdin.readline

n,m = map(int,input().split())
board = []
taxi = []
for i in range(n):
    location = list(map(int,input().split()))
    for j,t in enumerate(location):
        if t == 1:
            taxi.append((i,j))
    board.append(location)
print(abs(taxi[1][0]-taxi[0][0]) + abs((taxi[1][1]-taxi[0][1])))