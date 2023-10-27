t = int(input())
for case in range(1, t + 1):
    n, m = map(int, input().split())
    arr1 = sorted(list(input().split()))
    arr2 = sorted(list(input().split()))
    ans = 0
    i1 = 0
    i2 = 0
    while i1 != len(arr1) and i2 != len(arr2):
        if arr1[i1] == arr2[i2]:
            ans += 1
            i1 += 1
            i2 += 1
        elif arr1[i1] > arr2[i2] and i2 < len(arr2):
            i2 += 1
        elif arr1[i1] < arr2[i2] and i1 < len(arr1):
            i1 += 1
    print(f'#{case} {ans}')