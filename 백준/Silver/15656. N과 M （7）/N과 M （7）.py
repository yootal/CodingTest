import sys
input=sys.stdin.readline

def func(ans,cnt):
    if cnt == m:
        print(*ans)
        return
    for i in range(n):
        ans.append(num_list[i])
        func(ans,cnt+1)
        ans.pop()

n,m = map(int,input().split())
num_list = list(map(int,input().split()))
num_list.sort()

count = 0
func([],0)