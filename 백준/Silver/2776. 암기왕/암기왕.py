from bisect import bisect_left
from sys import stdin

inp = stdin.readline

for _ in range(int(inp())):
    N = int(inp())
    num1 = list(map(int, inp().split()))
    num1.sort()
    M = int(inp())
    num2 = list(map(int, inp().split()))
    for i in range(M):
        idx = bisect_left(num1, num2[i])
        if idx < N and num2[i] == num1[idx]:
            print(1)
        else:
            print(0)