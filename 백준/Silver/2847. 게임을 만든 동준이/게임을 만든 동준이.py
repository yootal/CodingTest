import sys
input = sys.stdin.readline

n = int(input())
clear = [int(input()) for _ in range(n)]
cnt = 0
prev = clear.pop()
while clear:
    last = clear.pop()
    while last >= prev:
        last -= 1
        cnt += 1
    prev = last
print(cnt)