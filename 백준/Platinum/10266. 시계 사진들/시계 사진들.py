from sys import stdin
input = stdin.readline

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

n = int(input())
a = sorted(map(int,input().split()))
b = sorted(map(int,input().split()))

a2 = [a[0] + (360000 - a[-1])]
for i in range(1,n):
    a2.append(a[i] - a[i-1])
b2 = [b[0] + (360000 - b[-1])]
for i in range(1,n):
    b2.append(b[i] - b[i-1])

a3 = a2 + a2[:-1]
f = failure(b2)
j = 0
for i in range(len(a3)):
    while j > 0 and a3[i] != b2[j]:
        j = f[j-1]
    if a3[i] == b2[j]:
        j += 1
    if j == len(b2):
        print('possible')
        exit()
print('impossible')