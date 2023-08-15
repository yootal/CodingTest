import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N,M = map(int,input().split())
    A = list(map(int,input().split()))
    B = list(map(int,input().split()))
    A.sort(reverse=True)
    B.sort(reverse=True)
    cnt = 0
    for a in A:
        for b in range(M):
            if B[b] < a:
                cnt += M - b
                break
    print(cnt)