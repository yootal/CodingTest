import sys
input = sys.stdin.readline

n,m = map(int,input().split())
card = list(map(int,input().split()))
for _ in range(m):
    card.sort()
    sum_card = card[0] + card[1]
    card[0] = sum_card
    card[1] = sum_card
print(sum(card))