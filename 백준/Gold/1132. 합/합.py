from sys import stdin
input = stdin.readline
    
n = int(input())
alpha = [[0,False] for _ in range(10)]

for _ in range(n):
    word = list(input().rstrip())
    value = 1
    alpha[ord(word[0])-65][1] = True
    for w in range(len(word)-1,-1,-1):
        alpha[ord(word[w])-65][0] += value
        value *= 10

alpha.sort(reverse=True)
if alpha[-1][1]:
    for i in range(8,-1,-1):
        if not alpha[i][1]:
            del alpha[i]
            break

ans = 0
for i in range(9):
    ans += alpha[i][0] * (9-i)
print(ans)