import sys
input = sys.stdin.readline

def failure(s):
    f = [0] * len(s)
    j = 0
    for i in range(1,len(s)):
        while j > 0 and s[i] != s[j]:
            j = f[j-1]
        if s[i] == s[j]:
            j += 1 
            f[i] = j
    return f

a = input().rstrip()
b = input().rstrip()
f = failure(b)
j = 0
for i in range(len(a)):
    while j > 0 and a[i] != b[j]:
        j = f[j-1]
    if a[i] == b[j]:
        j += 1
    if j == len(b):
        print(1)
        exit()
print(0)