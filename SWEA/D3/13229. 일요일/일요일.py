day = {'SUN': 0, 'MON': 1, 'TUE': 2, 'WED': 3, 'THU': 4, 'FRI': 5, 'SAT': 6}
t = int(input())
for case in range(1, t + 1):
    s = input()
    ans = 7 - day[s]
    print(f'#{case} {ans}')
