from sys import stdin, setrecursionlimit
setrecursionlimit(10**5)
input = stdin.readline

g = int(input())
p = int(input())
gate = list(range(g+1))
plane = [int(input()) for _ in range(p)]

def find(cur):
    if gate[cur] != cur:
        gate[cur] = find(gate[cur])
    return gate[cur]

for gi in plane:
    x = find(gi)
    if x == 0:
        break
    gate[x] = x - 1

ans = 0
for j in range(1,g+1):
    if gate[j] != j:
        ans += 1
print(ans)

