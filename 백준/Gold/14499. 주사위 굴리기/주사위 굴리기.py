import sys
input=sys.stdin.readline

def makedice():
    newdice = [[0],[0,0,0,0],[0]]
    return newdice

def east(dice):
    newdice = makedice()
    newdice[0][0] = dice[1][3]
    newdice[2][0] = dice[1][1]
    newdice[1][0] = dice[1][0]
    newdice[1][1] = dice[0][0]
    newdice[1][2] = dice[1][2]
    newdice[1][3] = dice[2][0]
    return newdice

def west(dice):
    newdice = makedice()
    newdice[0][0] = dice[1][1]
    newdice[2][0] = dice[1][3]
    newdice[1][0] = dice[1][0]
    newdice[1][1] = dice[2][0]
    newdice[1][2] = dice[1][2]
    newdice[1][3] = dice[0][0]
    return newdice

def north(dice):
    newdice = makedice()
    newdice[0][0] = dice[1][0]
    newdice[2][0] = dice[1][2]
    newdice[1][0] = dice[2][0]
    newdice[1][1] = dice[1][1]
    newdice[1][2] = dice[0][0]
    newdice[1][3] = dice[1][3]
    return newdice

def south(dice):
    newdice = makedice()
    newdice[0][0] = dice[1][2]
    newdice[2][0] = dice[1][0]
    newdice[1][0] = dice[0][0]
    newdice[1][1] = dice[1][1]
    newdice[1][2] = dice[2][0]
    newdice[1][3] = dice[1][3]
    return newdice

n,m,x,y,k = map(int,input().split())
game_map = [list(map(int,input().split())) for _ in range(n)]
command = list(map(int,input().split()))
# 1동 2서 3북 4남

dice = makedice()

for c in command:
    if c == 1:
        if y < m-1:
            y += 1
            dice = east(dice)
            if game_map[x][y] != 0:
                dice[2][0] = game_map[x][y]
                game_map[x][y] = 0
            else: 
                game_map[x][y] = dice[2][0]
            print(dice[0][0])
    elif c == 2:
        if y > 0:
            y -= 1
            dice = west(dice)
            if game_map[x][y] != 0:
                dice[2][0] = game_map[x][y]
                game_map[x][y] = 0
            else: 
                game_map[x][y] = dice[2][0]
            print(dice[0][0])
    elif c == 3:
        if x > 0:
            x -= 1
            dice = north(dice)
            if game_map[x][y] != 0:
                dice[2][0] = game_map[x][y]
                game_map[x][y] = 0
            else: 
                game_map[x][y] = dice[2][0]
            print(dice[0][0])
    else:
        if x < n-1:
            x += 1
            dice = south(dice)
            if game_map[x][y] != 0:
                dice[2][0] = game_map[x][y]
                game_map[x][y] = 0
            else: 
                game_map[x][y] = dice[2][0]
            print(dice[0][0])