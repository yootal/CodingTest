from math import pow

t = int(input())
for case in range(1, t + 1):
    n = int(input())
    cube = pow(n, 1 / 3)
    if round(cube) ** 3 == n:
        print(f'#{case} {round(cube)}')
    else:
        print(f'#{case} -1')