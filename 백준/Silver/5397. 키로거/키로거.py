import sys
input = sys.stdin.readline

def traverse():
    cur = nxt[0] # 첫 시작 인덱스
    while cur != -1:
        print(chr(dat[cur] + ord('a')), end = "")
        cur = nxt[cur]
    print()
    
def insert(addr,num):
    global unused
    dat[unused] = num 
    pre[unused] = addr # 새 원소의 pre에 삽입할 위치의 주소 대입
    nxt[unused] = nxt[addr] # 새 원소의 nxt에 삽입할 위치의 nxt값 대입

    # 삽입할 위치의 nxt값과 삽입할 위치 다음 원소의 pre값을 갱신
    if nxt[addr] != -1:
        pre[nxt[addr]] = unused
    nxt[addr] = unused
    
    unused += 1 # unused 증가
    
def erase(addr):
    # 이전 위치의 nxt를 삭제할 위치의 nxt로 변경
    nxt[pre[addr]] = nxt[addr]
    # 다음 위치의 pre를 삭제할 위치의 pre로 변경
    if nxt[addr] != -1:
        pre[nxt[addr]] = pre[addr]
    
for _ in range(int(input())):
    mx = 1000001
    dat = [-1] * mx
    pre = [-1] * mx
    nxt = [-1] * mx
    unused = 1
    cur = 0
    command = input().rstrip()
    for c in command:
        if c == '<':
            if pre[cur] != -1:
                cur = pre[cur]
        elif c == '>':
            if nxt[cur] != -1:
                cur = nxt[cur]
        elif c == '-':
            if pre[cur] != -1:
                erase(cur)
                cur = pre[cur]
        else:
            insert(cur,ord(c)- ord('a'))
            cur = nxt[cur]
    traverse()
    