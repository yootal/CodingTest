import sys
input=sys.stdin.readline

a = int(input())
list = list(map(int,input().split(" ")))
b = int(input())

print(list.count(b))