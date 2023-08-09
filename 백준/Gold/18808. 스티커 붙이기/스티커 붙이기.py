import sys
input=sys.stdin.readline
from collections import deque

n,m,k = map(int,input().split())
notebook = [[0] * m for _ in range(n)]

sticker = [[] for _ in range(k)]
size = []

# 스티커 모양이랑 사이즈 저장
for k2 in range(k):
    n2,m2 = map(int,input().split())
    size.append((n2,m2))
    for _ in range(n2):
        sticker[k2].append(list(map(int,input().split())))

# 스티커를 붙일 수 있는지 확인
def check(pop_sticker, pop_size, i, j):
    px,py = pop_size
    for x2 in range(i,i+px):
        for y2 in range(j,j+py):
            if x2 < 0 or x2 > n-1 or y2 < 0 or y2 > m-1:
                return False
            if pop_sticker[x2-i][y2-j] == 1 and notebook[x2][y2] == 1:
                return False         
    return True

# 스티커 붙이기
def attach(pop_sticker, pop_size, notebook, i, j):
    px,py = pop_size
    for x2 in range(i,i+px):
        for y2 in range(j,j+py):
            if pop_sticker[x2-i][y2-j] == 1 and notebook[x2][y2] == 0:
                notebook[x2][y2] = 1

# 스티커 회전
def rotate(pop_sticker, pop_size):
    px,py = pop_size
    rotate_sticker = [[0] * px for _ in range(py)]
    for i in range(px): 
        for j in range(py):
            rotate_sticker[j][px-1-i] = pop_sticker[i][j]
    return rotate_sticker

# 확인할 좌표 반복
def repeat(pop_sticker, pop_size, notebook):
    px,py = pop_size
    for i in range(n-px+1):
        for j in range(m-py+1):
            if check(pop_sticker, pop_size, i, j):
                attach(pop_sticker, pop_size, notebook, i, j)
                return True
    return False   

# 4번 회전 시키면서 조회
def inquiry(pop_sticker, pop_size, notebook):
    for _ in range(4):
        px,py = pop_size
        if not repeat(pop_sticker, pop_size, notebook):
            pop_sticker = rotate(pop_sticker, pop_size)
            pop_size = (py,px)
        else: 
            return     
    return     

Q = deque(sticker)
S = deque(size)

while Q:
    pop_sticker = Q.popleft()
    pop_size = S.popleft()
    inquiry(pop_sticker, pop_size, notebook)    
    
cnt = 0        
for note in notebook:
    cnt += note.count(1)
print(cnt)



    
