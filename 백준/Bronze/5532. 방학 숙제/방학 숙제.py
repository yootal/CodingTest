from math import ceil
l = int(input())
a = int(input())
b = int(input())
c = int(input())
d = int(input())
print(l - max(ceil(a/c),ceil(b/d)))