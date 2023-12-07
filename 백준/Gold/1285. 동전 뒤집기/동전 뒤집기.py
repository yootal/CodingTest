from sys import stdin
input = stdin.readline

n = int(input())
coin = [list(input().rstrip()) for _ in range(n)]
ans = n ** 2 # 최대 모든 칸 수

for bitmask in range(1 << n): # 행 뒤집는 경우의 수
    temp = [coin[r][:] for r in range(n)]
    for row in range(n):
        if bitmask & (1 << row): # 행 뒤집어 보고
            for col in range(n):
                if temp[row][col] == 'H':
                    temp[row][col] = 'T'
                else:
                    temp[row][col] = 'H'
    t_cnt = 0
    for col in range(n): # 열 별로 갯수 카운팅
        cnt = 0
        for row in range(n):
            if temp[row][col] == 'T':
                cnt += 1
        t_cnt += min(cnt, n-cnt) # 뒤집은게 더 적으면 뒤집은 기준으로
    ans = min(ans,t_cnt)
    
print(ans)
        