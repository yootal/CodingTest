from sys import stdin
input = stdin.readline

def make(cur, s):
    if cur == n + 1:
        s_replace = s.replace(' ', '')
        operation = []
        for x in s_replace:
            if x == '+':
                operation.append('+')
            elif x == '-':
                operation.append('-')
        s_split = s_replace.replace('+', '-').split('-')
        total = int(s_split[0])
        for y in range(len(operation)):
            if operation[y] == '+':
                total += int(s_split[y + 1])
            elif operation[y] == '-':
                total -= int(s_split[y + 1])
        if total == 0:
            print(s)
        return
    make(cur + 1, s + ' ' + str(cur))
    make(cur + 1, s + '+' + str(cur))
    make(cur + 1, s + '-' + str(cur))

t = int(input())
for _ in range(t):
    n = int(input())
    make(2, '1')
    print()