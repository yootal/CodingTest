import sys
import math

input = sys.stdin.readline


def dist(p1, p2):
    return math.sqrt((p1[0] - p2[0]) ** 2 + (p1[1] - p2[1]) ** 2)


def main():
    n = int(input())
    points = [tuple(map(float, input().split())) for _ in range(n)]
    m = int(input())
    for _ in range(m):
        p = int(input())
        l = list(map(int, input().split()))
        total = sum(dist(points[l[i]], points[l[i + 1]]) for i in range(p - 1))
        print(round(total))


if __name__ == "__main__":
    main()
