import sys
input = sys.stdin.readline

n = int(input())
milk = list(map(int,input().split()))
order = [0,1,2]

now = 0
ans = 0
for i in range(n):
    if milk[i] == order[now]:
        ans += 1
        now = (now + 1) % 3

print(ans)        
            