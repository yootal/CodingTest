l = list(map(int, input().split()))
x, y, r = map(int, input().split())
print(l.index(x) + 1 if x in l else 0)
