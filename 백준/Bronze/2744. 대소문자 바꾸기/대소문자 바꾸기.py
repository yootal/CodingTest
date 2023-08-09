S = input()
for i in S:
    if i.isupper():
        i = i.lower()
    else:
        i = i.upper()
    print(i, end='')