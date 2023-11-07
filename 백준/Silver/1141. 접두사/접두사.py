from sys import stdin
input = stdin.readline
    
n = int(input())
word = [input().rstrip() for _ in range(n)]
word.sort(key = lambda x: len(x))
ans = 0
for i in range(n):
    for j in range(i+1,n):
        if word[i] == word[j][:len(word[i])]:
            break
    else:
        ans += 1
print(ans)
