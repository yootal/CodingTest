t = int(input())
for case in range(1, t + 1):
    num, k = input().split()
    num_len = len(num)
    k = int(k)
    cur = {num}
    nxt = set()
    for _ in range(k):
        while cur:
            num_list = list(cur.pop())
            for i in range(num_len - 1):
                for j in range(i + 1, num_len):
                    num_list[i], num_list[j] = num_list[j], num_list[i]
                    nxt.add(''.join(num_list))
                    num_list[i], num_list[j] = num_list[j], num_list[i]
        cur, nxt = nxt, cur
    ans = max(cur)
    print(f'#{case} {ans}')
