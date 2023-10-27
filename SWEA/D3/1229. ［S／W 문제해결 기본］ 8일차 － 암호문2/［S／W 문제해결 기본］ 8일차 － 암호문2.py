for case in range(1, 11):
    n = int(input())
    original = list(map(int, input().split()))
    c = int(input())
    command = list(input().rstrip().split())
    cur = 0
    count = 0
    while count < c:
        if command[cur] == 'I':
            cur += 1
            idx = int(command[cur])
            cur += 1
            cnt = int(command[cur])
            cur += 1
            for x in range(cur + cnt - 1, cur - 1, -1):
                original.insert(idx, int(command[x]))
            cur += cnt
            count += 1
        elif command[cur] == 'D':
            cur += 1
            idx = int(command[cur])
            cur += 1
            en = int(command[cur])
            for x in range(en):
                original.pop(idx)
            cur += 1
            count += 1
    print(f"#{case}", end=" ")
    for cur in range(10):
        print(original[cur], end=" ")
    print()