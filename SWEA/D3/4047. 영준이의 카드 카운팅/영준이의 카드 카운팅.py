t = int(input())
for case in range(1, t+1):
    check = {'S': [True] * 13, 'D': [True] * 13, 'H': [True] * 13, 'C': [True] * 13}
    inp = input().rstrip()
    flag = True
    for i in range(0, len(inp), 3):
        if check[inp[i]][int(inp[i+1:i+3])-1]:
            check[inp[i]][int(inp[i+1:i+3])-1] = False
        else:
            flag = False
            break
    if flag:
        print(f'#{case}', end=" ")
        for k in check.keys():
            print(check[k].count(True), end=" ")
        print()
    else:
        print(f'#{case} ERROR')