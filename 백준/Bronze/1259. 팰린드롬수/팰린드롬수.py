import sys
input = sys.stdin.readline

while True:
    inp = input().rstrip()
    
    if inp == '0':
        exit()
    else:
        if inp == "".join(reversed(inp)):
            print("yes")
        else:
            print("no")