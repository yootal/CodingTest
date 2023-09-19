import sys 
input = sys.stdin.readline

n,m = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(n)]

up_down = n * m
left_right = 0
for i in range(n):
    for j in range(m):
        if j == 0:
            left_right += box[i][j]
        else:
            if box[i][j-1] < box[i][j]:
                left_right += (box[i][j] - box[i][j-1])
front_back = 0
for j in range(m):
    for i in range(n):
        if i == 0:
            front_back += box[i][j]
        else:
            if box[i-1][j] < box[i][j]:
                front_back += (box[i][j] - box[i-1][j])
        
answer = 2 * (up_down + left_right + front_back)
print(answer)