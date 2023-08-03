import sys
input=sys.stdin.readline

def dfs():
    global count
    if len(temp) == l:
        if count >= 1 and len(temp) - count >= 2:
            print("".join(temp))
        return
    for i in range(c):
            if len(temp) > 0 and temp[-1] < c_list[i] or not temp:
                temp.append(c_list[i])
                if c_list[i] in vow:
                    count += 1
                    dfs()
                    temp.pop()
                    count -= 1
                else:
                    dfs()
                    temp.pop()
            

l,c = map(int,input().split())
c_list = sorted(list(input().rstrip().split()))
vow = ['a','e','i','o','u']
temp = []
count = 0
dfs()