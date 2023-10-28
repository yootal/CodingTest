t = int(input())
for case in range(1, t + 1):
    score = list(map(int, input().split()))
    for i in range(5):
        if score[i] < 40:
            score[i] = 40
    ans = sum(score) // 5
    print(f'#{case} {ans}')