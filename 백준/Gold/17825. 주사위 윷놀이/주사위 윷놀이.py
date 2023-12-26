from sys import stdin
from collections import defaultdict
input = stdin.readline

dice = list(map(int, input().split()))

# 게임판의 점수 표현, 인덱스를 활용해 게임 진행
score = [0,2,4,6,8,10,12,14,16,18,
         20,22,24,26,28,30,32,34,36,38,
         40,13,16,19,22,24,28,27,26,25,
         30,35,0]

shortcut = defaultdict(int) # 파란색 칸 지름길
nxt = defaultdict(int) # 현재 칸에서 이동할 다음 칸
pos = [0] * 4 # 각 말의 위치

def calc(idx,total):
    global ans
    # 10번 다했으면 최대값 기록
    if idx == 10:
        ans = max(ans,total)
        return
    
    move = dice[idx]
    for i in range(4):
        cur = pos[i]
        # 도착했으면 건너뛰기
        if cur == 32:
            continue
        for j in range(move):
            if cur == 32:
                break
            # 시작이고 파란칸이면
            if j == 0 and shortcut[cur]:
                cur = shortcut[cur]
            # 아니면 다음칸
            else:
                cur = nxt[cur]
                
        # 도착했거나 말이 있는 곳이면 건너뛰기
        if cur != 32 and cur in pos:
            continue
        
        # 백트래킹
        pre = pos[i]
        pos[i] = cur
        calc(idx + 1,total + score[cur])
        pos[i] = pre
    
shortcut[5] = 21
shortcut[10] = 24
shortcut[15] = 26

for i in range(32):
    nxt[i] = i + 1
nxt[20] = 32
nxt[23] = 29
nxt[25] = 29
nxt[31] = 20
ans = 0

calc(0,0)
print(ans)
