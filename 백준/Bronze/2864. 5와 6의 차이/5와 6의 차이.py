import sys
input = sys.stdin.readline

a,b = input().rstrip().split()
min_a = ""
max_a = ""
min_b = ""
max_b = ""

for i in range(len(a)):
    if a[i] == '5' or a[i] == '6':
        min_a += '5'
        max_a += '6'
    else:
        min_a += a[i]
        max_a += a[i]
        
for i in range(len(b)):
    if b[i] == '5' or b[i] == '6':
        min_b += '5'
        max_b += '6'
    else:
        min_b += b[i]
        max_b += b[i]     


min_v = int(''.join(min_a)) + int(''.join(min_b))
max_v = int(''.join(max_a)) + int(''.join(max_b))
print(min_v,max_v)

