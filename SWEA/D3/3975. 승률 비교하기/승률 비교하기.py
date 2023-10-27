t = int(input())
result = []
for case in range(1, t + 1):
    a, b, c, d = map(int, input().split())
    alice = a / b
    bob = c / d
    if alice == bob:
        result.append(f'#{case} DRAW')
    elif alice > bob:
        result.append(f'#{case} ALICE')
    else:
        result.append(f'#{case} BOB')

for ans in result:
    print(ans)