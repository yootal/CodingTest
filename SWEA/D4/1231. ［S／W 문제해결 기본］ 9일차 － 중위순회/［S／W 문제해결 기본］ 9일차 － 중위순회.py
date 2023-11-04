from collections import defaultdict


def inorder(x):
    if left[x] != 0:
        inorder(left[x])
    print(value[x], end="")
    if right[x] != 0:
        inorder(right[x])


for case in range(1, 11):
    n = int(input())
    value = defaultdict(str)
    left = [0] * (n + 1)
    right = [0] * (n + 1)
    for _ in range(n):
        inp = list(input().rstrip().split())
        idx = int(inp[0])
        value[idx] = inp[1]
        if len(inp) >= 3:
            left[idx] = int(inp[2])
            if len(inp) >= 4:
                right[idx] = int(inp[3])
    print(f'#{case}', end=" ")
    inorder(1)
    print()
