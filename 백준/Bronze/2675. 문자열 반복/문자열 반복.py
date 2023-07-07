import sys
input=sys.stdin.readline

l = []

for _ in range(int(input())):
    l.append(list((input().rstrip().split(" "))))

for l1 in l:
    for l2 in l1[1]:
        print(f"{l2}"*int(l1[0]),end="")
    print("")