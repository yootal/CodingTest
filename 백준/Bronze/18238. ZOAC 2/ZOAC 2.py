import sys
input = sys.stdin.readline

inp = input().rstrip()
 
count = 0
check = 'A'
for i in inp:
    left = ord(i) - ord(check)
    right = ord(check) - ord(i)
 
    if left < 0:
        left += 26
    elif right < 0:
        right += 26
    
    count += min(left, right)
    check = i
    
print(count)