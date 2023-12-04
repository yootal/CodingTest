from sys import stdin
input = stdin.readline

n,k = map(int,input().split())
dp = [[[[False] * (436) for _ in range(31)] for _ in range(31)] for _ in range(31)]
ans = [''] * 31

# idx 위치, a의 개수, b의 개수, 쌍 cnt
def solve(idx,a,b,cnt):
    if idx == n:
        if cnt == k:
            return True
        else:
            return False
    
    if dp[idx][a][b][cnt]:
        return False
    dp[idx][a][b][cnt] = True
    
    ans[idx] = 'A'
    if solve(idx+1,a+1,b,cnt):
        return True
    
    ans[idx] = 'B'
    if solve(idx+1,a,b+1,cnt+a):
        return True
    
    ans[idx] = 'C'
    if solve(idx+1,a,b,cnt+a+b):
        return True
    
    return False

if solve(0,0,0,0):
    print(''.join(ans))
else:
    print(-1)
