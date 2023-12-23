from sys import stdin
input = stdin.readline

def solve(s):
    if '*' in s:
        # 앞에서부터
        count = 0
        for c in s:
            if c == '*':
                break
            elif c == ')':
                count -= 1
            else: # ? + (
                count += 1
            if count < 0:
                return False
        
        # 뒤에서부터
        count = 0
        for c in s[::-1]:
            if c == '*':
                break
            elif c == '(':
                count -= 1
            else:
                count += 1
            if count < 0:
                return False
        return True
    
    # 짝수가 아니면 불가능
    if length % 2 != 0:
        return False
    
    # 절반 넘어도 불가능
    cnt1 = s.count('(')
    cnt2 = s.count(')')
    if cnt1 > length // 2 or cnt2 > length // 2:
        return False
    
    # ?에 대입
    count = 0
    for c in s:
        if c == '?':
            if cnt1 < length // 2:
                c = '('
                cnt1 += 1
            else:
                c = ')'
        if c == '(':
            count += 1
        else:
            count -= 1
        if count < 0:
            return False
    return True
    
t = int(input())
for _ in range(t):
    s = list(input().rstrip())
    length = len(s)
    print('YES' if solve(s) else 'NO')