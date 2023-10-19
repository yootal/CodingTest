n  = int(input())

check = {'3','6','9'}
for i in range(1,n+1):
    num_str = list(str(i))
    cnt = 0
    for x in num_str:
        if x in check:
            cnt += 1
    if cnt == 0:
        print(i,end=" ")
    else:
        print('-'*cnt,end=" ")