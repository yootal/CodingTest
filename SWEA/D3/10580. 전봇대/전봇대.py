t = int(input())
for case in range(1, t + 1):
    n = int(input())
    line = []
    ans = 0
    for _ in range(n):
        p = tuple(map(int, input().split()))
        for i in range(len(line)):
            if line[i][0] > p[0] and line[i][1] < p[1]:
                ans += 1
            elif line[i][0] < p[0] and line[i][1] > p[1]:
                ans += 1
        line.append(p)
    print(f'#{case} {ans}')