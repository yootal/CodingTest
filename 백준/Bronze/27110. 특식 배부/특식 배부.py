n = int(input())
print(sum(min(int(x), n) for x in input().split()))