from sys import stdin
input = stdin.readline

def count(n,v):
    cnt = 0
    while n != 0:
        n //= v
        cnt += n
    return cnt

n,m = map(int,input().split())
print(min(count(n,2) - count(n-m,2) - count(m,2),
          count(n,5) - count(n-m,5) - count(m,5)))
    