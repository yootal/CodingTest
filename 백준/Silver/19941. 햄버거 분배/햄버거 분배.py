from sys import stdin
from collections import deque
input = stdin.readline

n,k = map(int,input().split())
pos = list(input().rstrip())
buger = deque()
person = deque() 

ans = 0
for i in range(n):
    if pos[i] == 'H':
        if len(person) > 0:
            while i - person[0] > k:
                person.popleft()
            if person:
                person.popleft()
                ans += 1
            else:
                buger.append(i)
        else:
            buger.append(i)
            
    elif pos[i] == 'P':
        if len(buger) > 0:
            while i - buger[0] > k:
                buger.popleft()
            if buger:
                buger.popleft()
                ans += 1
            else:
                person.append(i)
        else:
            person.append(i)

print(ans)