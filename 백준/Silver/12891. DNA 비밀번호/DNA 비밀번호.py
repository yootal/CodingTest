from sys import stdin
from collections import deque, defaultdict
input = stdin.readline

s,p = map(int,input().split())
dna = input().rstrip()
a,c,g,t = map(int,input().split())

cnt = defaultdict(int)
left, right = 0, p-1 
dq = deque(dna[left:right])
for i in dq:
    cnt[i] += 1
ans = 0

while right < s:
    cnt[dna[right]] += 1

    if cnt['A'] >= a and cnt['C'] >= c and cnt['G'] >= g and cnt['T'] >= t:
        ans += 1    
    
    cnt[dna[left]] -= 1
    left += 1
    right += 1

print(ans)    