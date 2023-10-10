from sys import stdin, maxsize
input = stdin.readline

n = int(input())
board = [list(map(int,input().split())) for _ in range(n)]

def bt(cur,arr,total):
    global ans
    if len(arr) == n:
        if board[cur][arr[0]] != 0:
            total += board[cur][arr[0]]
            ans = min(ans,total)
        return
    for x in range(n):
        if x not in arr and board[cur][x] != 0 and total + board[cur][x] < ans:
            arr.append(x)
            total += board[cur][x]
            bt(x,arr,total)
            arr.pop()        
            total -= board[cur][x]

ans = maxsize
for i in range(n):
    bt(i,[i],0)
print(ans)
    