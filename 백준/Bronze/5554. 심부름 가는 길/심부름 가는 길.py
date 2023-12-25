from sys import stdin
input = stdin.readline

total = sum([int(input()) for _ in range(4)])
print(total // 60)
print(total % 60)