l = list(map(int, input().split()))
l.sort()
print(sum(l) - l[0] + 1)