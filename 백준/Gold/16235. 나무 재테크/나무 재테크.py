from sys import stdin
from collections import defaultdict
input = stdin.readline

n, m, k = map(int, input().split())
energy = [[5] * n for _ in range(n)]

add_energy = []
for _ in range(n):
    add_energy.append(tuple(map(int, input().split())))

# tree_age = defaultdict(list)
tree_age = [[[] for _ in range(n)] for _ in range(n)]
for _ in range(m):
    x, y, z = map(int, input().split())
    # tree_age[(x - 1, y - 1)].append(z)
    tree_age[x-1][y-1].append(z)
# print(tree_age)


for _ in range(k):
    # 봄 
    die = []
    die_pos = []
    for i in range(n):
        for j in range(n):
            # tree_age[(i, j)].sort()
            tree_age[i][j].sort()
            # for k in range(len(tree_age[(i, j)])):
            for k in range(len(tree_age[i][j])):
                # if energy[i][j] >= tree_age[(i, j)][k]:
                #     energy[i][j] -= tree_age[(i, j)][k]
                #     tree_age[(i, j)][k] += 1
                if energy[i][j] >= tree_age[i][j][k]:
                    energy[i][j] -= tree_age[i][j][k]
                    tree_age[i][j][k] += 1
                else:
                    k -= 1
                    break
            # die.append(tree_age[(i, j)][k + 1:])
            # die_pos.append((i, j))
            # tree_age[(i, j)] = tree_age[(i, j)][:k + 1]
            die.append(tree_age[i][j][k + 1:])
            die_pos.append((i, j))
            tree_age[i][j] = tree_age[i][j][:k + 1]
    # 여름
    for i in range(len(die)):
        e_die = sum([x // 2 for x in die[i]])
        energy[die_pos[i][0]][die_pos[i][1]] += e_die
    # 가을
    for i in range(n):
        for j in range(n):
            # for k in range(len(tree_age[(i, j)])):
            for k in range(len(tree_age[i][j])):
                # if tree_age[(i, j)][k] % 5 == 0:
                if tree_age[i][j][k] % 5 == 0:
                    for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1), (1, 1), (-1, -1), (-1, 1), (1, -1)):
                        nx = i + dx
                        ny = j + dy
                        if 0 <= nx < n and 0 <= ny < n:
                            # tree_age[(nx, ny)].append(1)
                            tree_age[nx][ny].append(1)
    # 겨울
    for i in range(n):
        for j in range(n):
            energy[i][j] += add_energy[i][j]

ans = 0
for i in range(n):
    for j in range(n):
        # ans += len(tree_age[(i, j)])
        ans += len(tree_age[i][j])
print(ans)
