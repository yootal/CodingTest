from sys import stdin
from math import ceil
input = stdin.readline

s = input().rstrip()
l = len(s)

if s == s[0] * l:
    print(-1)
elif s[:l//2][::-1] == s[ceil(l/2):]:
    print(l-1)
else:
    print(l) 