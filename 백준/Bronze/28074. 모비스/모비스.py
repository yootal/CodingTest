import sys

word = ['M', 'O', 'B', 'I', 'S']
s = input()

for c in word:
    if c not in s:
        print("NO")
        sys.exit()
print('YES')