for i in range(int(input())):
    a, b = input().split()
    for j in range(len(a)):
        if a[j] != b[j]:
            print('ERROR')
            break
        if j == len(a) - 1:
            print('OK')
