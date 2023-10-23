from itertools import combinations

t = int(input())
for case in range(1,t+1):
    num = list(map(int,input().split()))
    result = set()
    for comb in combinations(num,3):
        result.add(sum(comb))
    result = list(result)
    result.sort(reverse=True)
    print(f"#{case} {result[4]}")