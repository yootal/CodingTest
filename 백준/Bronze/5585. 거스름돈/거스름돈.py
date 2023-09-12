money = int(input())
change = 1000 - money
cnt = 0
coin = [500,100,50,10,5,1]

for c in coin:
    cnt += change // c
    change = change % c

print(cnt)