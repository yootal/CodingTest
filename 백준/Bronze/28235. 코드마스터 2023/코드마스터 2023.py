from sys import stdin
input = stdin.readline

s = input().rstrip()
if s == 'SONGDO':
    print('HIGHSCHOOL')
elif s == 'CODE':
    print('MASTER')
elif s == '2023':
    print('0611')
else:
    print('CONTEST')