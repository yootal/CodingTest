from collections import deque

for case in range(1,11):
    n = int(input())
    num = list(map(int,input().split()))
    dq = deque(num)
    w = 1
    while True:
        if dq[0] - w <= 0:
            dq.popleft()
            dq.append(0)
            break
        dq.append(dq.popleft()-w)
        if w == 5:
            w = 1
        else:
            w += 1
    print(f"#{n}",end=" ")
    print(*dq)