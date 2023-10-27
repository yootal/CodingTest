t = int(input())
ans_list = []
for case in range(1, t + 1):
    ans = input()
    while len(ans) != 1:
        total = 0
        for i in range(len(ans)):
            total += int(ans[i])
        ans = str(total)
    ans_list.append(ans)
for i in range(1, t+1):
    print(f'#{i} {ans_list[i-1]}')
