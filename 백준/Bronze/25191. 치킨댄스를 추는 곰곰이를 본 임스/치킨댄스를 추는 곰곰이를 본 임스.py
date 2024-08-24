n = int(input())
a, b = map(int, input().split())
cnt = a // 2 + b
print(cnt if n >= cnt else n)