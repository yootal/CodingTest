n = int(input())

count = 0
row = [0] * n

def queen_check(x):
    for i in range(x):
        if row[x] == row[i] or abs(row[x] - row[i]) == abs(x - i):
            return False
    
    return True

def n_queens(x):
    global count
    if x == n:
        count += 1
        return

    else:
        for i in range(n):
            row[x] = i
            if queen_check(x):
                n_queens(x+1)

n_queens(0)
print(count)