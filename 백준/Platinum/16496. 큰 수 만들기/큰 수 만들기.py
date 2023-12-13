from sys import stdin
input = stdin.readline

n = int(input())
num = list(input().rstrip().split())
compare = []
for x in num:
    temp = x[:]
    l = len(temp)
    while len(temp) < 10:
        temp += temp[len(temp)-l]
    compare.append([temp,x])
compare.sort(key=lambda x: x[0], reverse=True)
ans = ''.join([item[1] for item in compare])
print(ans if int(ans) != 0 else 0)