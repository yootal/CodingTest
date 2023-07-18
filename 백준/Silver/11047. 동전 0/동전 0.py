import sys
input = sys.stdin.readline

size,money = map(int,input().split())

coin = []

for _ in range(size):
    coin.append(int(input()))

coin_count = 0
for c in range(len(coin)-1,-1,-1):
    if money >= coin[c]:
        coin_count += money//coin[c]
        money %= coin[c]
        if money == 0:
            break
    
print(coin_count)