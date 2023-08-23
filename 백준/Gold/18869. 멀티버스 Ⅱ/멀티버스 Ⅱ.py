import sys
input = sys.stdin.readline

m,n = map(int,input().split())
space = [list(map(int,input().split())) for _ in range(m)]
compress_space = []

def lower_idx(target,len,sp):
    st = 0
    en = len
    while st < en:
        mid = (st + en) // 2
        if sp[mid] >= target:
            en = mid
        else:
            st = mid + 1
    return st

def compress(sp):
    compress_sp = []
    sp_set = sorted(list(set(sp)))
    sp_set_len = len(sp_set)
    for planet in sp:
            compress_sp.append(lower_idx(planet,sp_set_len,sp_set))
    return compress_sp

for sp in space:
    compress_space.append(compress(sp))

def space_check(s1,s2):
    for k in range(n):
        if s1[k] == s2[k]:
            continue
        else:
            return False
    return True

ans = 0
for i in range(m):
    for j in range(i+1,m):
        if space_check(compress_space[i],compress_space[j]):
            ans += 1
            
print(ans)