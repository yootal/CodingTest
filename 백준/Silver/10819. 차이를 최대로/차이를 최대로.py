from sys import stdin
input = stdin.readline

n = int(input())
num = list(map(int,input().split()))

def calc(arr):
    global ans
    total = 0
    for i in range(1,n):
        total += abs(num[arr[i-1]] - num[arr[i]])
    ans = max(ans,total)

def bt(arr):
    if len(arr) == n:
        calc(arr)
        return
    for i in range(n):
        if i not in arr:
            arr.append(i)
            bt(arr)
            arr.pop()

ans = 0
bt([])
print(ans)
    