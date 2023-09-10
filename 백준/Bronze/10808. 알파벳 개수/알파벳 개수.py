a = [0] * 26
inp = input()
for c in inp:
    a[ord(c)-ord('a')] += 1
    
print(*a)