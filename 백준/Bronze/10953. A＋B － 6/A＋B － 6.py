import sys
input = sys.stdin.readline

n = int(input())
for _ in range(n):
    inp = list(map(int,input().rstrip().split(",")))
    print(sum(inp))
