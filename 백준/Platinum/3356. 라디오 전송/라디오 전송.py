from sys import stdin
input = stdin.readline

def failure(s):
    f = [0] * n
    j = 0
    for i in range(1,n):
        while j > 0 and s[i] != s[j]:
            j = f[j-1]
        if s[i] == s[j]:
            j += 1
            f[i] = j
    return n - f[-1]

n = int(input())
s = input().rstrip()
print(failure(s))