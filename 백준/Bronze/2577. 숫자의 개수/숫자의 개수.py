a = [0] * 10
v = 1
for _ in range(3):
    inp = int(input())
    v *= inp
v = str(v)
for c in v:
    a[ord(c) - ord('0')] += 1
for a2 in a:
    print(a2)