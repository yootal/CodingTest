import sys
from collections import defaultdict
input=sys.stdin.readline

n = int(input())
word_list = []
value = defaultdict(int)
value_list = []

for i in range(n):
    word_list.append(input().rstrip())        

for word in word_list:
    for i in range(len(word)):
        w = 10 ** (len(word) - i -1)
        value[word[i]] += w

for v in value.values():
    if v > 0:
        value_list.append(v)
    
value_list.sort(reverse=True)
ans = 0
for i in range(len(value_list)):
    ans += value_list[i] * (9-i)
    
print(ans)