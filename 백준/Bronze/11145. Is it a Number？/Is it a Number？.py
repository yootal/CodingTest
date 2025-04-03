for _ in range(int(input())):
    s = input().strip()
    if not s.isdigit():
        print("invalid input")
    else:
        print(int(s))
