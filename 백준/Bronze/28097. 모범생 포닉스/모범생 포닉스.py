N = int(input())
time = list(map(int, input().split()))
total = sum(time) + (8 * (N - 1))
print(total // 24, total % 24)