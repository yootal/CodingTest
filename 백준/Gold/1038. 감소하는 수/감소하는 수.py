from sys import stdin
from itertools import combinations
input = stdin.readline

n = int(input())
temp = []
for i in range(1,11):
    for j in combinations(range(10),i):
        temp.append(int(''.join(map(str,reversed(j)))))
temp.sort()
print(temp[n] if n < len(temp) else -1)