from sys import stdin
from collections import defaultdict
input = stdin.readline

r, c, k = map(int, input().split())
r_length = 3
c_length = 3

arr = [[0 for _ in range(100)] for _ in range(100)]
for i in range(3):
    row = list(map(int, input().split()))
    for j in range(3):
        arr[i][j] = row[j]

def r_operation():
    global r_length, c_length
    for i in range(r_length):
        cnt = defaultdict(int)
        for j in range(c_length):
            if arr[i][j] == 0:
                continue
            cnt[arr[i][j]] += 1
        cnt_sort = sorted(cnt.items(), key=lambda x: (x[1], x[0]))
        for k in range(len(cnt)):
            if k > 49:
                break
            arr[i][2 * k] = cnt_sort[k][0]
            arr[i][2 * k + 1] = cnt_sort[k][1]
            c_length = max(c_length, 2 * (k + 1))
        for l in range(2 * (k + 1), 100):
            arr[i][l] = 0

def c_operation():
    global r_length, c_length
    for i in range(c_length):
        cnt = defaultdict(int)
        for j in range(r_length):
            if arr[j][i] == 0:
                continue
            cnt[arr[j][i]] += 1
        cnt_sort = sorted(cnt.items(), key=lambda x: (x[1], x[0]))
        for k in range(len(cnt)):
            if k > 49:
                break
            arr[2 * k][i] = cnt_sort[k][0]
            arr[2 * k + 1][i] = cnt_sort[k][1]
            r_length = max(r_length, 2 * (k + 1))
        for l in range(2 * (k + 1), 100):
            arr[l][i] = 0

ans = 0
while ans <= 100 and arr[r - 1][c - 1] != k:
    if r_length >= c_length:
        r_operation()
    else:
        c_operation()
    ans += 1
print(ans if ans <= 100 else -1)