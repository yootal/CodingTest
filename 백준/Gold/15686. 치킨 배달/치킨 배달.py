import sys
input=sys.stdin.readline

def close(record):
    global min_value
    
    if cc - len(record) == m:
        difference = [x for x in chicken if x not in record]
        min_value = min(min_value,min_count(difference))
        return
    
    for c in chicken:
        if c not in record:
            if len(record) == 0:
                record.append(c)
                close(record)
                record.pop()
            elif record[-1][0] < c[0]:
                record.append(c)
                close(record)
                record.pop()
            elif record[-1][0] == c[0] and record[-1][1] < c[1]:
                record.append(c)
                close(record)
                record.pop()

def min_count(chicken):
    min_count = 0
    for r1,r2 in room:
        min_d = sys.maxsize
        for c1,c2 in chicken:
            min_d = min(min_d,abs(r1-c1) + abs(r2-c2))
        min_count += min_d
    return min_count


n,m = map(int,input().split())
min_value = sys.maxsize
board = []
room = []
chicken = []
for i in range(n):
    data = list(map(int,input().split()))
    for j in range(n):
        if data[j] == 1:
            room.append((i,j))
        elif data[j] == 2:
            chicken.append((i,j))
    board.append(data)
cc = len(chicken)

close([])
print(min_value)