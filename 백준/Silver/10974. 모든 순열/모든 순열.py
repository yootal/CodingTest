from sys import stdin
from itertools import permutations
input = stdin.readline

n = int(input())
num = list(range(1,n+1))
for i in permutations(num,n):
    print(*i)