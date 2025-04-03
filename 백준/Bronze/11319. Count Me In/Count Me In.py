for _ in range(int(input())):
    s = input()
    cnt = 0
    total = 0
    for c in s:
        if c in "AEIOUaeiou":
            cnt += 1
        if c != " ":
            total += 1
    print(total - cnt, cnt)
