import sys
input = sys.stdin.readline

for _ in range(int(input())):
    inp = list(input().rstrip().split())
    for s in inp:
        print(s[::-1],end=" ")
    print()