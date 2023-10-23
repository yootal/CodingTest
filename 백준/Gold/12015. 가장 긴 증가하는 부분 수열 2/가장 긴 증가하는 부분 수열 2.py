import sys
from bisect import bisect_left
input = sys.stdin.readline

n = int(input())
num = list(map(int,input().split()))

seq = [0]
for item in num:
    if seq[-1] < item:
        seq.append(item)
    else:
        idx = bisect_left(seq,item)
        seq[idx] = item

print(len(seq) - 1)