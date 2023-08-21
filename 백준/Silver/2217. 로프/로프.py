import sys
input = sys.stdin.readline

n = int(input())
rope = [int(input()) for _ in range(n)]
rope.sort()
ans = 0
for i in range(1,n+1):
    ans = max(ans, rope[n-i] * i)
    
print(ans)