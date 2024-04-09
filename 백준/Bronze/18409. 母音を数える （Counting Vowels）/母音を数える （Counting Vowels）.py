vowel = {'a', 'e', 'i', 'o', 'u'}
input()
cnt = 0
for x in list(input()):
    if x in vowel:
        cnt += 1
print(cnt)