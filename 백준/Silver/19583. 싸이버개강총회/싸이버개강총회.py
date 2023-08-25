import sys
input = sys.stdin.readline
from collections import defaultdict

s,e,q = map(str,input().split())
check = defaultdict(str)
check2 = set()

while True:
    try:
        time, nickname = input().rstrip().split()
        if time <= s:
            check[nickname] = time
        elif e <= time <= q:
            if nickname in check:
                check2.add(nickname)
    except:
        break
                
print(len(check2))