from sys import stdin


def find():
    for i in range(n - 2):
        if line[i] < line[i + 1] + line[i + 2]:
            return line[i] + line[i + 1] + line[i + 2]
    return -1


inp = stdin.readline

n = int(inp())
line = [int(inp()) for _ in range(n)]
line.sort(reverse=True)
print(find())