num = input().rstrip()
num_count = [0] * 10
for n in num:
    if n == '6' or n == '9':
        if num_count[6] == num_count[9]:
            num_count[6] += 1
        else:
            num_count[9] += 1
    else:
        num_count[int(n)] += 1
        
print(max(num_count))