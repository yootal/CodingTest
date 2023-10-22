from sys import stdin
input = stdin.readline

n = int(input())
target = list(input().rstrip())
ans = 0

for i in range(n-1):
    word = input().rstrip()
    temp = target[:]
    cnt = 0
    
    for w in word:
        if w in temp:
            temp.remove(w)
        else:
            cnt += 1
    
    if cnt < 2 and len(temp) < 2:
        ans += 1
                
print(ans)
