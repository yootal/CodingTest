for case in range(1,11):
    n = int(input())
    check = input().rstrip()
    sentence = input().rstrip()
    ans = 0
    en = len(check)
    for st in range(len(sentence)):
        if check == sentence[st:en]:
            ans += 1
        en += 1
    print(f"#{case} {ans}")