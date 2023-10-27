vowel = {'a', 'e', 'i', 'o', 'u'}
t = int(input())
for case in range(1, t + 1):
    ans = ""
    word = input().rstrip()
    for i in range(len(word)):
        if word[i] in vowel:
            continue
        ans += word[i]
    print(f"#{case} {ans}")
