import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
book_cnt = defaultdict(int)

for _ in range(n):
    book = input().rstrip()
    book_cnt[book] += 1
    
max_cnt = min(book_cnt, key = lambda x: (-book_cnt[x],x))
print(max_cnt)