from sys import stdin
input = stdin.readline        

n = int(input())
arr = list(map(int,input().split()))

ans = 0
while sum(arr) != 0:
    flag = True
    for i in range(n):
        if arr[i] % 2 == 0:
            continue
        ans += 1
        arr[i] -= 1
        flag = False
        break
    if flag:
        ans += 1
        for i in range(n):
            arr[i] //= 2

print(ans)