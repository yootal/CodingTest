from heapq import heappush, heappop

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    q = []
    ans = []
    for _ in range(n):
        command = list(map(int, input().split()))
        if command[0] == 1:
            heappush(q, -command[1])
        else:
            if q:
                ans.append(-heappop(q))
            else:
                ans.append(-1)
    print(f'#{case}', *ans)