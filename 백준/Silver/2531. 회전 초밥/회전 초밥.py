import sys
input = sys.stdin.readline
    
n,d,k,c = map(int,input().split())
dishes = [int(input()) for _ in range(n)]
dishes_rotation = dishes[0:k-1]
dishes += dishes_rotation

ate_count = [0] * (d+1)
ate_count[c] += 1
ate_kind_count = 1
ans = 1

def eat(sushi):
    global ate_kind_count, ans
    if ate_count[sushi] == 0:
        ate_kind_count += 1
        ans = max(ans,ate_kind_count)
    ate_count[sushi] += 1
    
def over_eat(sushi):
    global ate_kind_count
    ate_count[sushi] -= 1
    if ate_count[sushi] == 0:
        ate_kind_count -= 1

for i in range(n+k-1):
    if i >= k:
        over_eat(dishes[i-k])
    eat(dishes[i])

print(ans)
