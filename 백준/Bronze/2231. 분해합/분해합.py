i = int(input())

result = False
for j in range(i):
    sj =str(j)
    sj2=sum(list(map(int,sj)))
    if sj2+j == i:
        print(j)
        result = True
        break
if result == False: print(0)