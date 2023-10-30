from sys import stdin
input = stdin.readline        

n = int(input())
drink = list(map(float,input().split()))
_max = max(drink)
drink.pop(drink.index(_max))
print(_max+(sum(drink)/2))