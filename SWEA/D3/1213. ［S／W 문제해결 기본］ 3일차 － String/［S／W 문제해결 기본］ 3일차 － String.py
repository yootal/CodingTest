for case in range(1, 11):
    n = int(input())
    target = input()
    sentence = input()
    ans = sentence.count(target)
    print(f"#{case} {ans}")