from sys import stdin
input = stdin.readline

def calc(x,cnt):
    if cnt == 1:
        return x
    temp = calc(x,cnt//2)
    if cnt % 2 == 0:
        return temp * temp % mod
    else:
        return x * temp * temp % mod
    
m = int(input())
mod = 1000000007
ans = 0
for _ in range(m):
    n,s = map(int,input().split())
    ans += (calc(n,mod-2) * s) % mod
    ans %= mod

print(ans)