import sys
input = sys.stdin.readline

symbol = {'-': 0, '\\': 1, '(': 2, '@': 3, '?': 4, '>': 5, '&': 6, '%': 7, '/': -1}
while True:
    inp = input().rstrip()
    
    if inp == '#':
        break
    
    ans = 0
    for i in range(len(inp)):
        ans += symbol[inp[i]] * 8**(len(inp)-i-1)
        
    print(ans)