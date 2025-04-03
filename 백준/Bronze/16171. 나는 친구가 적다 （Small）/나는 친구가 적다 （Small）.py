a = input()
b = input()
temp = ''
for c in a:
    if c.isalpha():
        temp += c
print(1 if b in temp else 0)
