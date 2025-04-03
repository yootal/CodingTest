def sol(movements):
    min = 0
    cnt = 0

    for a, b in movements:
        cnt += a
        cnt -= b
        min = max(min, -cnt)

    return min


if __name__ == "__main__":
    for _ in range(int(input())):
        m = int(input().strip())
        move = [tuple(map(int, input().split())) for _ in range(m)]
        print(sol(move))
