import sys
input = sys.stdin.readline

inp = input().rstrip()
for i in range(0,len(inp),10):
    print(inp[i:i+10])