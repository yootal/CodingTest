from sys import stdin
from itertools import permutations
input = stdin.readline

n = int(input())
c = [tuple(input().split()) for _ in range(n)]

def check(num):
    for question,s,b in c:
        s2 = 0
        b2 = 0
        for i in range(3):
            if int(question[i]) == num[i]:
                s2 += 1
                continue
            if num[i] in set(map(int,question)):
                b2 += 1 
        if int(s) != s2 or int(b) != b2:
            return False
    return True
    
cnt = 0
for num in permutations(list(range(1,10)),3):
    if check(num):
        cnt += 1
print(cnt)