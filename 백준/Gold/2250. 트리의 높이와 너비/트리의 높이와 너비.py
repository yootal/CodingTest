import sys
sys.setrecursionlimit(10**6)
input=sys.stdin.readline
from collections import defaultdict, deque

n = int(input())
lc = [0] * (n+1) # 왼쪽 자식
rc = [0] * (n+1) # 오른쪽 자식
cnt = [0] * (n+1) # 하위 노드 갯수
board = [0] * (n+1) # 틀 인덱스 
parent = [-1] + [0] * n # 부모 기록 
level_list = defaultdict(list) # 같은 레벨 확인용

# 좌우 자식 기록
for _ in range(n):
    m,l,r = map(int,input().split())
    if l != -1:
        lc[m] = l
        parent[l] = m
    if r != -1:
        rc[m] = r 
        parent[r] = m

root = parent.index(0)
# print("root ",root)
    
# 하위 노드 갯수 등록
def counting(node):
    if lc[node] == 0 and rc[node] == 0:
        cnt[node] = 1
    elif lc[node] == 0:
        cnt[node] = counting(rc[node]) + 1
    elif rc[node] == 0:
        cnt[node] = counting(lc[node]) + 1
    else:
        cnt[node] = counting(lc[node]) + counting(rc[node]) + 1
    return cnt[node]

counting(root)
# print("cnt",cnt)
    
def check_level():
    q = deque([(root,1)])
    while q:
        node, level = q.popleft()
        level_list[level].append(node)
        if lc[node] != 0:
            q.append((lc[node],level + 1))
        if rc[node] != 0:
            q.append((rc[node],level + 1))

check_level()
# print(level_list)

# root 노드 위치
board[root] = cnt[lc[root]] + 1

# 각 노드의 보드 상 위치
def select_position(node):
    if lc[node] == 0 and rc[node] == 0:
        return
    board[lc[node]] = board[node] - cnt[rc[lc[node]]] - 1
    board[rc[node]] = board[node] + cnt[lc[rc[node]]] + 1
    select_position(lc[node])
    select_position(rc[node])
    
select_position(root)
# print(board)

level = 1 # 시작 레벨
ans_width = 0 # 정답 너비
ans_level = 1 # 정답 레벨

while level_list[level]:
    width = board[level_list[level][-1]] - board[level_list[level][0]]
    if width > ans_width:
        ans_level = level
        ans_width = width
    level += 1
    
print(ans_level, ans_width + 1)