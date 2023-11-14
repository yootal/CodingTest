t = int(input())
for case in range(1, t + 1):
    num = list(map(int, input().split()))
    print(f'#{case} {round(sum(num)/len(num))}')
