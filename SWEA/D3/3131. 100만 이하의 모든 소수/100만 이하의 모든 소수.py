def eratosthenes():
    num = [False] * 1000001
    ans = []
    for i in range(2,1000001):
        if not num[i]:
            ans.append(i)
            for j in range(i*i,1000001,i):
                num[j] = True
    return ans

ans = eratosthenes()
print(*ans)