from sys import stdin, maxsize
from collections import defaultdict
input = stdin.readline

t = int(input())
for _ in range(t):
    w = input().rstrip()
    k = int(input())
    cnt = defaultdict(list)
    for i in range(len(w)):
        if w.count(w[i]) >= k:
            cnt[w[i]].append(i)
    if not cnt:
        print(-1)
    else:
        _min = maxsize
        _max = 0
        for i in cnt:
            for j in range(len(cnt[i]) - k + 1):
                l = cnt[i][j+k-1] - cnt[i][j] + 1
                _min = min(_min,l)
                _max = max(_max,l)
        print(_min,_max)