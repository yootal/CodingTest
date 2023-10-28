t = int(input())
for case in range(1, t + 1):
    sorted_list = sorted(list(map(int, input().split())))
    if sorted_list.count(sorted_list[0]) == 1:
        print(f'#{case} {sorted_list[0]}')
    else:
        print(f'#{case} {sorted_list[2]}')