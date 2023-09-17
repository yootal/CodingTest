import sys
input = sys.stdin.readline

n = int(input())
check_j = [True] * n
check_diagonal1 = [True] * (2*n-1)
check_diagonal2 = [True] * (2*n-1)
ans = 0

def n_queen(i):
    global ans
    if i == n:
        ans += 1
        return
    for j in range(n):
        if check_j[j] and check_diagonal1[i+j] and check_diagonal2[i-j+n-1]:
            check_j[j] = False
            check_diagonal1[i+j] = False
            check_diagonal2[i-j+n-1] = False
            n_queen(i+1)
            check_j[j] = True
            check_diagonal1[i+j] = True
            check_diagonal2[i-j+n-1] = True
    
n_queen(0)
print(ans)