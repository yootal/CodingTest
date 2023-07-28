import sys
input = sys.stdin.readline

n = int(input())
towers = list(map(int,input().split()))
stack = []
ans = [0] * n
count = 0

for i in range(n-1,-1,-1):
    while count > 0 and towers[i] > stack[-1][1]:
        p = stack.pop()
        count -= 1
        ans[p[0]] = i + 1
    stack.append([i,towers.pop()])
    count += 1
    
print(" ".join(map(str,ans)))