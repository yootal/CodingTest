t = int(input())
dict = {'ZRO':0,'ONE':1,'TWO':2,'THR':3,'FOR':4,'FIV':5,'SIX':6,'SVN':7,'EGT':8,'NIN':9}
for case in range(1,t+1):
    c,n = input().rstrip().split()
    num = list(input().rstrip().split())
    num.sort(key = lambda x: dict[x])
    print(f"#{case}")
    print(*num)