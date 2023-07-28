import sys
input = sys.stdin.readline

n = int(input())
num_list = list(map(int,input().split()))

stack = []
ans = [0] * n

for n2 in range(n):
    while stack and stack[-1][1] < num_list[n2]:
        s1,s2 = stack.pop()
        ans[s1] = num_list[n2]
    stack.append((n2, num_list[n2]))
for s in stack:
    ans[s[0]] = -1

print(" ".join(str(ans2) for ans2 in ans))