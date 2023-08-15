import sys
input = sys.stdin.readline

N = int(input())
score = [list(input().rstrip().split()) for _ in range(N)]
score.sort(key = lambda x: (-int(x[1]),int(x[2]),-int(x[3]),x))
for s in score:
    print(s[0])
