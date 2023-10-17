from sys import stdin
input = stdin.readline

def back_tacking(x):
    global ans
    if len(num) == 2:
        ans = max(ans, x)
        return
    for i in range(1,len(num)-1):
        value = num[i-1] * num[i+1]
        temp = num.pop(i) 
        back_tacking(x+value)
        num.insert(i,temp)

n = int(input())
num = list(map(int,input().split()))
ans = 0
back_tacking(0)
print(ans)