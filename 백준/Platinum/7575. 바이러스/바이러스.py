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

def match(s,code_info,f):
    j = 0 
    for i in range(code_info[0]):
        while j > 0 and code_info[1][i] != s[j]:
            j = f[j-1]
        if code_info[1][i] == s[j]:
            j += 1
        if j == k:
            return True
    return False

n,k = map(int,input().split())
code = []
for _ in range(n):
    m = int(input())
    inp = list(map(int,input().split()))
    code.append((m,inp))

for i in range(code[0][0]-k+1):
    s = code[0][1][i:i+k]
    s_reverse = s[::-1]
    f = failure(s)
    f_reverse = failure(s_reverse)
    for c in range(n):
        if match(s,code[c],f) or match(s_reverse,code[c],f_reverse):
            continue
        else:
            break
    else:
        print('YES')
        exit()
print('NO')
