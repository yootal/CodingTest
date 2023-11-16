from math import gcd


def lcm(a, b):
    return int(a / gcd(a, b) * b)


t = int(input())
for case in range(1, t + 1):
    s1, s2 = input().split()
    ls1 = len(s1)
    ls2 = len(s2)
    _lcm = lcm(len(s1), len(s2))
    if s1 * (_lcm // ls1) == s2 * (_lcm // ls2):
        print(f'#{case} yes')
    else:
        print(f'#{case} no')