def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)


def lcm(a, b):
    return int(a / gcd(a, b) * b)


t = int(input())
for case in range(1, t + 1):
    s1, s2 = input().split()
    lens = sorted([len(s1), len(s2)])
    _lcm = lcm(lens[1], lens[0])
    if s1 * (_lcm // len(s1)) == s2 * (_lcm // len(s2)):
        print(f'#{case} yes')
    else:
        print(f'#{case} no')