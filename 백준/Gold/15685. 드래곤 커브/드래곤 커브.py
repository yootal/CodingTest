import sys
input = sys.stdin.readline

dx = [1,0,-1,0]
dy = [0,-1,0,1]
dir = [(1,0),(0,-1),(-1,0),(0,1)]

def dragon_curve(x,y,d,g):
    nx = x + dx[d]
    ny = y + dy[d]
    repeat_curve([(x,y),(nx,ny)],0,g)

def repeat_curve(points,count,gen):
    if count == gen:
        for px,py in points:
            board[px][py] = 1
        return
    last_x, last_y = points[-1]
    directions = []
    for i in range(len(points)-1,0,-1):
        dif = tuple(a - b for a, b in zip(points[i], points[i-1]))
        if dif == dir[0]:
            directions.append(1)
        elif dif == dir[1]:
            directions.append(2)
        elif dif == dir[2]:
            directions.append(3)
        elif dif == dir[3]:
            directions.append(0)
    for d in directions:
        nx = last_x + dx[d]
        ny = last_y + dy[d]
        points.append((nx,ny))
        last_x = nx
        last_y = ny
    repeat_curve(points,count + 1,gen)

N = int(input())
case = [list(map(int,input().split())) for _ in range(N)]
board = [[0] * 101 for _ in range(101)]

for c in case:
    dragon_curve(c[0],c[1],c[2],c[3])
    
square_count = 0
for i in range(101):
    for j in range(101):
        if board[i][j] == 1:
           if 0 <= (i + 1) < 101 and 0 <= (j + 1) < 101:
                if board[i+1][j] == 1 and board[i][j+1] == 1 and board[i+1][j+1] == 1:
                    square_count += 1
    
print(square_count)