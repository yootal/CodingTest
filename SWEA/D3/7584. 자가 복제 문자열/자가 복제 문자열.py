t = int(input())
for case in range(1, t + 1):
    k = int(input())
    k -= 1
    while k % 2 == 1:
        k //= 2
    if k % 4 == 0:
        print(f'#{case} 0')
    else:
        print(f'#{case} 1')