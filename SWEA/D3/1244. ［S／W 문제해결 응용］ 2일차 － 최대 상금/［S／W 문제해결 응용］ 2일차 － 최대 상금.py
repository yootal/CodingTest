t = int(input())
for case in range(1, t + 1):
    num, k = input().split()
    n = len(num)
    k = int(k)
    now = {num}
    nxt = set()
    for _ in range(k):
        while now:
            num2 = list(now.pop())
            for i in range(n - 1):
                for j in range(i + 1, n):
                    num2[i], num2[j] = num2[j], num2[i]
                    nxt.add(''.join(num2))
                    num2[i], num2[j] = num2[j], num2[i]
        now, nxt = nxt, now
    print(f'#{case} {max(map(int, now))}')