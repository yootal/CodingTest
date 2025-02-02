N = int(input())
cnt = sum(int(input()) == 1 for _ in range(N))
print("Junhee is cute!" if cnt > N // 2 else "Junhee is not cute!")