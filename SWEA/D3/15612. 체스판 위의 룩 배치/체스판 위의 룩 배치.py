def check():
    flag = True
    cnt = 0
    for i in range(8):
        inp = input()
        for j in range(8):
            if inp[j] == 'O':
                cnt += 1
                if row_check[i] or col_check[j]:
                    flag = False
                row_check[i] = True
                col_check[j] = True
    if flag and cnt == 8:
        return True
    else:
        return False


t = int(input())
for case in range(1, t + 1):
    row_check = [False] * 8
    col_check = [False] * 8
    print(f'#{case} yes' if check() else f'#{case} no')
