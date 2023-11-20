inp = list(map(int,input().split()))
if inp == list(range(1,9)):
    print('ascending')
elif inp == list(range(8,0,-1)):
    print('descending')
else:
    print('mixed')
