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

def check(part):
    j = 0
    cnt = 0
    part_f = failure(part)
    for i in range(len(s)):
        while j > 0 and s[i] != part[j]:
            j = part_f[j-1]
        if s[i] == part[j]:
            j += 1
        if j == len(part):
            cnt += 1
            j = part_f[j-1]
    return cnt

s = input().rstrip()
f = failure(s)
l = len(s)
while True:
    pos = l
    l = f[l-1]
    if l == 0:
        print(-1)
        break
    if s[:l] == s[-l:] == s[pos-l:pos]:
        if check(s[pos-l:pos]) > 2:
            print(s[:l])
            exit()
