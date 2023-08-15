import sys
input = sys.stdin.readline

S = input().rstrip()
ans = []
for i in range(len(S)):
    ans.append(S[i:])
ans.sort()
for ans2 in ans:
    print(ans2)
