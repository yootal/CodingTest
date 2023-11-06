from sys import stdin
input = stdin.readline

n = int(input())
for _ in range(n):
    s1,s2 = map(list,input().rstrip().split())
    idx1 = []
    idx2 = []
    for i in range(len(s1)):
        if s1[i] == 'a':
            idx1.append(i)
        if s2[i] == 'a':
            idx2.append(i)
    ans = 0
    for i in range(len(idx1)):
        ans += abs(idx1[i] - idx2[i])
    print(ans)