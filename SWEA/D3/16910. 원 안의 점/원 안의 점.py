from itertools import permutations
t = int(input())
for case in range(1,t+1):
    n = int(input())
    ans = 0
    points = list(range(-1*n,n+1))
    for p in permutations(points,2):
        if p[0]**2 + p[1]**2 <= n**2:
            ans += 1
    for i in range(0,n+1):
        if i == 0:
            ans += 1
        else:
            if i**2 * 2 <= n**2:
                ans += 2
            else:
                break
    print(f"#{case} {ans}")