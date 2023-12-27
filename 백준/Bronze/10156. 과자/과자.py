from sys import stdin
input = stdin.readline

k,n,m = map(int,input().split())
print(k*n-m if k*n-m > 0 else 0)