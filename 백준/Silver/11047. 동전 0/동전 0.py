import sys
input = sys.stdin.readline

n,k = map(int,input().split())
coins = [int(input()) for _ in range(n)]

ans = 0
for coin in reversed(coins):
    if k >= coin:
        ans += k//coin
        k %= coin
        if k == 0:
            break
    
print(ans)
