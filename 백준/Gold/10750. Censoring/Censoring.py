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

def kmp():
    ans = []
    kmp_record = [0] * (len(s)+1)
    j = 0
    for i in range(len(s)):            
        while j > 0 and s[i] != t[j]:
            j = f[j-1]
        ans.append(s[i])
        if s[i] == t[j]:
            if j == len(t)-1:
                for _ in range(len(t)):
                    ans.pop()
                j = kmp_record[len(ans)]
            else:
                j += 1
        kmp_record[len(ans)] = j
    return ''.join(ans)
        
s = input().rstrip()
t = input().rstrip()
f = failure(t)
print(kmp())