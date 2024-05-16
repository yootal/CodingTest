from sys import stdin

input = stdin.readline
a,b,c = map(int, input().split())
print(max(b,a-b) * max(c,a-c) * 4)