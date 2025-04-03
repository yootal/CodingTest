n = int(input())
l = list(map(int, input().split()))
o = [x for x in l if l.count(x) == 1]
print(l.index(max(o)) + 1 if o else "none")
