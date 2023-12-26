import sys

input = sys.stdin.readline


def recur(sr, sc, start_value, k):
    global r, c

    if k == 1:
        plus_r = False
        if r % 2 != 0:
            r = r - 1
            plus_r = True
        plus_c = False
        if c % 2 != 0:
            c = c - 1
            plus_c = True
        value = start_value
        if plus_r:
            value = value + 2
        if plus_c:
            value = value + 1

        print(value)
        exit(0)

    next = 1 << (k - 1)
    ns = 1 << (2 * (k - 1))
    if sr <= r < sr + next and sc <= c < sc + next:
        recur(sr, sc, start_value, k - 1)
        return
    if sr <= r < sr + next and sc + next <= c < sc + 2 * next:
        recur(sr, sc + next, start_value + ns, k - 1)
        return
    if sr + next <= r < sr + 2 * next and sc <= c < sc + next:
        recur(sr + next, sc, start_value + ns * 2, k - 1)
        return
    if sr + next <= r < sr + 2 * next and sc + next <= c < sc + 2 * next:
        recur(sr + next, sc + next, start_value + ns * 3, k - 1)
        return


N, r, c = map(int, input().split())
recur(0, 0, 0, N)
