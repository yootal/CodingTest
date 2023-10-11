from sys import stdin
from math import sqrt
input = stdin.readline

def solve(n):
    if int(sqrt(n)) == sqrt(n):
        return 1
    
    for i in range(1, int(sqrt(n)) + 1):
        if int(sqrt(n - i**2)) == sqrt(n - i**2):
            return 2
        
    for i in range(1, int(sqrt(n)) + 1):
        for j in range(1, int(sqrt(n - i**2)) + 1):
            if int(sqrt(n - i**2 - j**2)) == sqrt(n - i**2 - j**2):
                return 3

    return 4

n = int(input())
print(solve(n))
