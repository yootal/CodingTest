import sys
input=sys.stdin.readline

def func(ans,cnt):
    if cnt == m:
        print(*ans)
        return
    for i in range(n):
        if num_list[i] not in ans:
            if cnt != 0 and ans[-1] < num_list[i] or cnt == 0:
                ans.append(num_list[i])
                func(ans,cnt+1)
                ans.pop()

n,m = map(int,input().split())
num_list = list(map(int,input().split()))
num_list.sort()

count = 0
func([],0)