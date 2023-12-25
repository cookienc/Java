import sys

input = sys.stdin.readline
a, b, c = map(int, input().split())


def recur(a, b, c):
    if b == 0:
        return 1 % c
    if b == 1:
        return a % c

    if b % 2 == 0:
        return (recur(a, b / 2, c) ** 2) % c
    return (a * (recur(a, (b - 1) / 2, c) ** 2)) % c


print(recur(a, b, c))
