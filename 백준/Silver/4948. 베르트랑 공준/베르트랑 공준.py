def prime_count(n):

    count = 0
    
    for j in range(n+1, 2*n+1):
        if j == 2 or j == 3:
            count += 1 
            continue
        else:
            check = True
            for i in range(2, int(j**0.5) + 1):
                if j % i == 0:
                    check = False
                    break
            if check == True:
                count += 1 

    return count


while 1:
    inp = int(input())
    if inp != 0:
        print(prime_count(inp))
    else:
        break