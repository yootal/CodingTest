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
a = list(input().rstrip().split())
b = list(input().rstrip().split())

a_long = a + a[:-1]
f = failure(b)
j = 0
cnt = 0
for i in range(len(a_long)):
    while j > 0 and a_long[i] != b[j]:
        j = f[j-1]
    if a_long[i] == b[j]:
        j += 1
    if j == len(b):
        cnt += 1
        j = f[j-1]
print(f'1/{n//cnt}')