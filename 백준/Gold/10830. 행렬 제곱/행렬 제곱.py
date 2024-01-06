from sys import stdin
input = stdin.readline

n,b = map(int,input().split())
a = [list(map(int,input().split())) for _ in range(n)]

def mul(x,y):
    new = [[0] * len(x) for _ in range(len(x))]
    for r in range(len(x)):
        for c in range(len(x)):
            for k in range(len(x)):
                new[r][c] += x[r][k] * y[k][c]
            new[r][c] %= 1000
    return new

def divide(matrix,cnt):
    if cnt == 1:
        return matrix
    temp = divide(matrix,cnt//2)
    if cnt % 2:
        return mul(mul(temp,temp),matrix)
    else:
        return mul(temp,temp)
    
ans = divide(a,b)
for row in ans:
    for num in row:
        print(num%1000,end=' ')
    print()