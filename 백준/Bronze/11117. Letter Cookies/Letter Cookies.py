from collections import Counter

for _ in range(int(input())):
    letters = input()
    words = [input() for _ in range(int(input()))]
    lCnt = Counter(letters)

    for word in words:
        cnt = Counter(word)
        print("YES" if all(cnt[c] <= lCnt[c] for c in cnt) else "NO")
