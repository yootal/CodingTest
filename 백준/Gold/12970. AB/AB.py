from sys import stdin
input = stdin.readline
    
n,k = map(int,input().split())
s = ['B' for _ in range(n)]
count = 0
max_count = 0

for i in range(n//2+1):
    max_count = max(max_count,i*(n-i))

if max_count < k:
    print(-1)
    exit()
    
while count != k:
    idx = n-1
    count -= s.count('A')
    s[idx] = 'A'
    while idx > 0 and s[idx-1] == 'B' and count != k:
        s[idx] = 'B'
        idx -= 1
        s[idx] = 'A'
        count += 1
        
print(''.join(s))