import sys
input = sys.stdin.readline

n = int(input())
h_list = []
for _ in range(n):
    h_list.append(int(input()))
    
stack = []
area = []

for h in range(n):
    if not stack:
        stack.append([h_list[h],h])
    else:
        if stack[-1][0] > h_list[h]:
            while stack and stack[-1][0] > h_list[h]:
                height, index = stack.pop()
                area.append(height * (h - index))
            if h_list[h] < height:
                if stack and stack[-1][0] == h_list[h]:
                    continue
                else:
                    stack.append([h_list[h],index])
        elif stack[-1][0] < h_list[h]:
            stack.append([h_list[h],h])
for s in stack:
    area.append(s[0] * (n-s[1]))
    
print(max(area))