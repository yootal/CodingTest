from sys import stdin
input = stdin.readline

def update(state,idx):
    diff = tab1[idx] - tab2[idx]
    if diff < 0:
        state[idx] = -1
    elif diff == 0:
        state[idx] = 0
    else:
        state[idx] = 1

n = int(input())
tab1 = list(map(int,input().split()))
tab2 = list(map(int,input().split()))
state = [0] * n
for i in range(n):
    update(state,i)

cnt = 0
need_update = n - state.count(0)
while need_update > 0:
    cnt += 1
    check = 0
    for i in range(n):
        if state[i] != 0:
            check = state[i]
            for j in range(i,n):
                if state[j] != check:
                    break
                if check > 0:
                    tab1[j] -= 1
                else:
                    tab1[j] += 1
                update(state,j)
                need_update = n - state.count(0)
            break
print(cnt)