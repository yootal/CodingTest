def count():
    cnt = 0
    while True:
        try:
            s = input()
            cnt += 1
        except EOFError:
            break
    return cnt


if __name__ == '__main__':
    print(count())