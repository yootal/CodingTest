t = int(input())
for case in range(1, t + 1):
    s = list(input())
    n = len(s)
    if n == 1:
        print('..#..')
        print('.#.#.')
        print(f'#.{s[0]}.#')
        print('.#.#.')
        print('..#..')
    else:
        print('..#.' * n, end="")
        print('.')
        print('.#.#' * n, end="")
        print('.')
        for i in range(n):
            print(f'#.{s[i]}.', end="")
        print('#')
        print('.#.#' * n, end="")
        print('.')
        print('..#.' * n, end="")
        print('.')