for _ in range(int(input())):
    check = []
    inp = list(input())
    check.append(inp[0])
    for x in range(1, len(inp)):
        if inp[x] != check[-1]:
            check.append(inp[x])
    print(''.join(check))