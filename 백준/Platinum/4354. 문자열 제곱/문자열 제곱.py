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

def check(l):
    j = 0
    cnt = 0
    for i in range(len(s)):
        if s[i] != s[j]:
            return 0
        j += 1
        if j == l:
            j = 0
            cnt += 1
    return cnt

while True:
    s = input().rstrip()
    if s == '.':
        break    
    f = failure(s)
    n = 1
    l = len(s)
    while True:
        l = f[l-1]
        if l == 0:
            break
        if len(s) % l != 0:
            continue
        n = max(n,check(l))
    print(n)