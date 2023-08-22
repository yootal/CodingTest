import sys
input = sys.stdin.readline

n,k = map(int,input().split())
num = [False] * (n+1)
num[0],num[1] = True,True

cnt = 0
for i in range(2,n+1):
    if not num[i]:
        cnt += 1
        if cnt == k:
            print(i)
            exit()
        num[i] = True
        for j in range(i*2,n+1,i):
            if not num[j]:
                cnt += 1
                if cnt == k:
                    print(j)
                    exit()
                num[j] = True
    else:
        continue 