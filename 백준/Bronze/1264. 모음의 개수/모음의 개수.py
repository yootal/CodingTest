vowel = {'a','e','i','o','u'}
while True:
    s = input()
    if s == '#':
        break
    print(sum([1 for c in s.lower() if c in vowel]))