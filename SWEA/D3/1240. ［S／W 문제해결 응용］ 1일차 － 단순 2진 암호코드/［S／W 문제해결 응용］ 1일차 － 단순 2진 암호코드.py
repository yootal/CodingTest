code = {'0001101':0,'0011001':1,'0010011':2,'0111101':3,'0100011':4,'0110001':5,'0101111':6,'0111011':7,'0110111':8,'0001011':9}

def find():
    for i in range(n-1,-1,-1):
        for j in range(m-1,-1,-1):
            if board[i][j] == '1':
                return (i,j)

def check(num):
    odd = num[0] + num[2] + num[4] + num[6]
    even = num[1] + num[3] + num[5] + num[7]
    if ((odd * 3) + even) % 10 == 0:
        print(f'#{case} {sum(num)}')
    else:
        print(f'#{case} 0')

t = int(input())
for case in range(1,t+1):
    n,m = map(int,input().split())
    board = [list(input().rstrip()) for _ in range(n)]
    s = find()
    num = []
    for j in range(s[1]-56+1,s[1],7):
        num.append(code[''.join(board[s[0]][j:j+7])])
    check(num)
        