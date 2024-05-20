from collections import Counter

t = int(input())
num = list(map(int,input().split()))
counter = Counter(num)
print(counter[t])