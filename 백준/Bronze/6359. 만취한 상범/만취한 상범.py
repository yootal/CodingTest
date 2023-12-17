from sys import stdin
input = stdin.readline

for _ in range(int(input())):
    n = int(input())
    num = [False] * (n+1)
    for i in range(2,n+1):
        for j in range(i,n+1,i):
            if not num[j]:
                num[j] = True
            else:
                num[j] = False
    print(num.count(False)-1)
            