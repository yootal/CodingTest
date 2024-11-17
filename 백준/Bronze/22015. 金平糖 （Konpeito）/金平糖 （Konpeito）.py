l = list(map(int, input().split()))
print(sum(max(l) - x for x in l))