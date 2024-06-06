num=list(map(int,input().split()))
cnt = 0;
for v in num:
    if v == 1:
        cnt+=1
print(1 if cnt > 1 else 2)