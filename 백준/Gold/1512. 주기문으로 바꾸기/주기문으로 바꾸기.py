from sys import stdin, maxsize
input = stdin.readline

n = int(input())
s = list(input().rstrip())

if n == len(s):
    print(0)
    exit()
    
dna_kind = ('A','C','G','T')
dna = {'A':0,'C':1,'G':2,'T':3}
ans = maxsize

gap = n
while gap > 0:
    cnt = [[0] * 4 for _ in range(gap)]
    for i in range(0,len(s),gap):
        for j in range(gap):
            if i+j >= len(s):
                break
            cnt[j][dna[s[i+j]]] += 1
    cycle = []
    for i in range(gap):
        cycle.append(dna_kind[cnt[i].index(max(cnt[i]))])
    total = 0
    for i in range(0,len(s),gap):
        for j in range(gap):
            if i+j >= len(s):
                break
            if cycle[j] != s[i+j]:
                total += 1
    ans = min(ans,total)
    gap -= 1
    
print(ans)