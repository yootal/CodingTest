import sys
input=sys.stdin.readline

def func(cur,sum):
    global count
    if cur >= n:
        return
    
    sum += num_list[cur]

    if sum == s:
        count += 1

    func(cur+1, sum)
    func(cur+1, sum - num_list[cur])

n,s = map(int,input().split())
num_list = list(map(int,input().split()))

count = 0
func(0,0)
print(count)