from sys import stdin, maxsize
from itertools import combinations
input = stdin.readline        

def calc_dist(a,b):
    dist = 0
    for i,j in zip(a,b):
        if i != j:
            dist += 1
    return dist
    
t = int(input())
for _ in range(t):
    n = int(input())
    mbti = list(input().rstrip().split())
    if n > 32:
        print(0)
    else:
        ans = maxsize
        for a,b,c in combinations(mbti,3):
            ans = min(ans,calc_dist(a,b)+calc_dist(b,c)+calc_dist(c,a))
        print(ans)