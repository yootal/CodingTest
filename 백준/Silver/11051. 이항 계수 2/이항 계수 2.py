import sys
input = sys.stdin.readline

n,k = map(int,input().split())
comb = [[0] * 1001 for _ in range(1001)]
for i in range(1,1001):
    comb[i][0] = comb[i][i] = 1
    for j in range(1,i):
        comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % 10007
print(comb[n][k])
    