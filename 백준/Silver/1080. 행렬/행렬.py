from sys import stdin
input = stdin.readline

n,m = map(int,input().split())
matrix1 = [list(int(x) for x in input().rstrip()) for _ in range(n)]
matrix2 = [list(int(x) for x in input().rstrip()) for _ in range(n)] 

def reverse_matrix(i,j):
    for x in range(i,i+3):
        for y in range(j,j+3):
              matrix1[x][y] = 1 - matrix1[x][y]
              
ans = 0
if (n < 3 or m < 3) and matrix1 != matrix2:
    print(-1)
    exit()
else:
    for i in range(n-2):
        for j in range(m-2):
            if matrix1[i][j] != matrix2[i][j]:
                ans += 1
                reverse_matrix(i,j)

if matrix1 != matrix2:
    print(-1)
else:
    print(ans)
