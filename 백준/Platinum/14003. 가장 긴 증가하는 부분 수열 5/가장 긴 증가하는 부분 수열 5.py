from sys import stdin, maxsize
from bisect import bisect_left
input = stdin.readline

n = int(input())
num = list(map(int,input().split()))
record = [0] * n
seq = [-maxsize]

# 몇 번째 수인지 기록 해둬야 출력가능
for i in range(n):
    item = num[i]
    if seq[-1] < item:
        record[i] = len(seq)
        seq.append((item))
    else:
        idx = bisect_left(seq,item)
        record[i] = idx
        seq[idx] = item

ans = [0] * (len(seq)-1)
cnt = len(seq) - 1
for i in range(n-1,-1,-1):
    if record[i] == cnt:
        cnt -= 1
        ans[cnt] = num[i] 

print(len(ans))
print(*ans)