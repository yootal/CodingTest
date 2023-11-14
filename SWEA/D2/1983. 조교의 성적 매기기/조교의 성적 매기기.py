grade = ('A+', 'A0', 'A-', 'B+', 'B0', 'B-', 'C+', 'C0', 'C-', 'D0')

t = int(input())
for case in range(1, t + 1):
    n, k = map(int, input().split())
    score = []
    for i in range(1, n + 1):
        a, b, c = map(int, input().split())
        total = a * 35 + b * 45 + c * 20
        if i == k:
            check = total
        score.append(total)
    score.sort(reverse=True)
    idx = score.index(check)
    print(f'#{case} {grade[idx // (n // 10)]}')
