from sys import stdin
input = stdin.readline

n = int(input())
w = sorted(list(map(int,input().split())))

num = 1
for weight in w:
    if num < weight:
        break
    num += weight
print(num)