from bisect import bisect_left

T = int(input())
for _ in range(T):
    N = int(input())
    num1 = list(map(int, input().split()))
    num1.sort()
    M = int(input())
    num2 = list(map(int, input().split()))
    for i in range(len(num2)):
        idx = bisect_left(num1, num2[i])
        if idx < len(num1) and num2[i] == num1[bisect_left(num1, num2[i])]:
            print(1)
        else:
            print(0)