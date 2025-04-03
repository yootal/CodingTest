from collections import Counter

s = input()
cnt = Counter(s)
oCnt = sum(1 for count in cnt.values() if count % 2 == 1)
print(max(0, oCnt - 1))
