import sys
input=sys.stdin.readline

def check(eggs):
    count = 0
    for egg in eggs:
        if egg[0] <= 0:
            count += 1
    return count

def back_tracking(idx,eggs):
    global ans
    if idx == n:
        ans = max(ans, check(eggs))
        return
    
    if eggs[idx][0] <= 0: # 현재 계란 내구도 없을 때
        back_tracking(idx + 1, eggs)
    else: # 현재 계란 내구도가 남아있을 때 (현재 계란 제외, 내구도 없는 계란 제외)
        is_all_broken = True
        for i in range(n):
            if idx != i and eggs[i][0] > 0:
                is_all_broken = False
                eggs[idx][0] -= eggs[i][-1]
                eggs[i][0] -= eggs[idx][-1]
                back_tracking(idx + 1, eggs)
                eggs[idx][0] += eggs[i][-1]
                eggs[i][0] += eggs[idx][-1]
        if is_all_broken:
            back_tracking(n, eggs)
            
n = int(input())
eggs = []
for _ in range(n):
    eggs.append(list(map(int,input().split())))
ans = 0
back_tracking(0,eggs)
print(ans)
