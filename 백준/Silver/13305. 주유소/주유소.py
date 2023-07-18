import sys
input = sys.stdin.readline

n = int(input())
dis = list(map(int,input().split()))
pri = list(map(int,input().split()))

total = 0
price = pri[0]

for i in range(len(pri)-1):
    if pri[i] <= price:
        price = pri[i]
    total += (price * dis[i])

print(total)