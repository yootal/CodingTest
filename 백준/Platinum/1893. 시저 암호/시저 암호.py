import sys
from collections import defaultdict
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

t = int(input())
for _ in range(t):
    a = input().rstrip()
    w = input().rstrip()
    s = input().rstrip()
    a_length = len(a)
    w_length = len(w)
    s_length = len(s)
    a_idx = defaultdict(int)
    s_idx = defaultdict(int)
    
    for a1 in range(a_length):
        a_idx[a[a1]] = a1

    ans = []
    f = failure(w)

    for shift in range(a_length):
        j = 0
        cnt = 0
        for i in range(a_length):
            s_idx[a[i]] = (a_idx[a[i]] + shift) % a_length
            
        for i in range(s_length):
            while j > 0 and a_idx[s[i]] != s_idx[w[j]]:
                j = f[j-1]
            if a_idx[s[i]] == s_idx[w[j]]:
                j += 1
            if j == w_length:
                cnt += 1
                if cnt > 1:
                    break
                j = f[j-1]
        if cnt == 1:
            ans.append(shift)
            
    if len(ans) == 0:
        print("no solution")
    elif len(ans) == 1:
        print(f"unique: {ans[0]}")
    else:
        print("ambiguous: ", end = "")
        print(*ans)