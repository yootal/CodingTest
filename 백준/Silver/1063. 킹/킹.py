king,stone,n = map(str,input().split())

k = [ord(king[0]) - ord('A') + 1,int(king[1])]
s = [ord(stone[0]) - ord('A') + 1,int(stone[1])]

for _ in range(int(n)):
    m = input()
    if m == 'R':
        if k[1] == s[1] and k[0] + 1 == s[0]:
            if s[0] + 1 > 8:
                continue
            else:
                k[0] += 1
                s[0] += 1
        else:
            if k[0] + 1 > 8:
                continue
            k[0] += 1
    elif m == 'L':
        if k[1] == s[1] and k[0] - 1 == s[0]:
            if s[0] - 1 < 1:
                continue
            else:
                k[0] -= 1
                s[0] -= 1
        else:
            if k[0] - 1 < 1:
                continue
            k[0] -= 1
    elif m == 'B':
        if k[0] == s[0] and k[1] - 1 == s[1]:
            if s[1] - 1 < 1:
                continue
            else:
                k[1] -= 1
                s[1] -= 1
        else:
            if k[1] - 1 < 1:
                continue
            k[1] -= 1
    elif m == 'T':
        if k[0] == s[0] and k[1] + 1 == s[1]:
            if s[1] + 1 > 8:
                continue
            else:
                k[1] += 1
                s[1] += 1
        else:
            if k[1] + 1 > 8:
                continue
            k[1] += 1
    elif m == 'RT':
        if k[0] + 1 == s[0] and k[1] + 1 == s[1]:
            if s[0] + 1 > 8 or s[1] + 1 > 8:
                continue
            else:
                k[0] += 1
                k[1] += 1
                s[0] += 1
                s[1] += 1
        else:
            if k[0] + 1 > 8 or k[1] + 1 > 8:
                continue
            k[0] += 1
            k[1] += 1
    elif m == 'LT':
        if k[0] - 1 == s[0] and k[1] + 1 == s[1]:
            if s[0] - 1 < 1 or s[1] + 1 > 8:
                continue
            else:
                k[0] -= 1
                k[1] += 1
                s[0] -= 1
                s[1] += 1
        else:
            if k[0] - 1 < 1 or k[1] + 1 > 8:
                continue
            k[0] -= 1
            k[1] += 1
    elif m == 'RB':
        if k[0] + 1 == s[0] and k[1] - 1 == s[1]:
            if s[0] + 1 > 8 or s[1] - 1 < 1:
                continue
            else:
                k[0] += 1
                k[1] -= 1
                s[0] += 1
                s[1] -= 1
        else:
            if k[0] + 1 > 8 or k[1] - 1 < 1:
                continue
            k[0] += 1
            k[1] -= 1
    elif m == 'LB':
        if k[0] - 1 == s[0] and k[1] - 1 == s[1]:
            if s[0] - 1 < 1 or s[1] - 1 < 1:
                continue
            else:
                k[0] -= 1
                k[1] -= 1
                s[0] -= 1
                s[1] -= 1
        else:
            if k[0] - 1 < 1 or k[1] - 1 < 1:
                continue
            k[0] -= 1
            k[1] -= 1

print(chr(k[0]+ord('A')-1),end="")
print(k[1])
print(chr(s[0]+ord('A')-1),end="")
print(s[1])