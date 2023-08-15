for _ in range(int(input())):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
 
    A.sort()
    B.sort()
 
    count = 0
    pair = 0
 
    for i in range(N):
        while True:
            if count == M or A[i] <= B[count]:
                pair += count
                break
            else:
                count += 1
 
    print(pair)