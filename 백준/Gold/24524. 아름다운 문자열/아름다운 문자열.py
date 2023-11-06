from sys import stdin
input = stdin.readline

s = input().rstrip()
t = input().rstrip()

cnt = 0
idx_cnt = [0] * len(t)
t_set = set(t)

for x in s:
    if x in t_set:
        if x == t[0]:
            idx_cnt[0] += 1
        else:
            idx = t.find(x)
            if idx_cnt[idx-1]:
                idx_cnt[idx-1] -= 1
                idx_cnt[idx] += 1
                
print(idx_cnt[-1])