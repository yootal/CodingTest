import sys

n = int(input())
l = list(map(int, input().split()))

l2 = sorted(list(set(l)))
index_dict = {value: index for index, value in enumerate(l2)}

for x in range(n):
    print(index_dict[l[x]], end=" ")