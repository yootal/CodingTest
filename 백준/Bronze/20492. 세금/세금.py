from sys import stdin
input = stdin.readline

n = int(input())
print(int(n*0.78),int(n*0.8 + (n*0.2*0.78)))