from sys import stdin
input = stdin.readline

n = int(input())
front,back = input().rstrip().split('*')
for _ in range(n):
    file = input().rstrip()
    if file[:len(front)] == front and file[-len(back):] == back and len(file) >= len(front) + len(back):
        print("DA")
    else:
        print("NE")
    