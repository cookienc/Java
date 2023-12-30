import sys
from itertools import permutations

input = sys.stdin.readline

N, M, k = map(int, input().split())
area = [list(map(int, input().split())) for _ in range(N)]
moves = [list(map(int, input().split())) for _ in range(k)]

answer = sys.maxsize


def findMinimum(result):
    minimum = sys.maxsize
    for r in range(N):
        minimum = min(minimum, sum(result[r]))
    return minimum


def rotate(order):
    global copy_area, moves, N, M
    R, C, S = moves[order]
    sr, sc = R - S - 1, C - S - 1
    er, ec = R + S - 1, C + S - 1

    tmp = [[0 for _ in range(M)] for _ in range(N)]
    while sr < er and sc < ec:
        # 위
        for c in range(sc, ec):
            tmp[sr][c + 1] = copy_area[sr][c]
        # 오른쪽
        for r in range(sr, er):
            tmp[r + 1][ec] = copy_area[r][ec]
        # 아래
        for c in range(ec, sc, -1):
            tmp[er][c - 1] = copy_area[er][c]
        # 왼쪽
        for r in range(er, sr, -1):
            tmp[r - 1][sc] = copy_area[r][sc]

        sr += 1
        sc += 1
        er -= 1
        ec -= 1

    if sr == er and sc == ec:
        tmp[sr][sc] = copy_area[sr][sc]

    sr, sc = R - S - 1, C - S - 1
    er, ec = R + S - 1, C + S - 1
    for r in range(sr, er + 1):
        for c in range(sc, ec + 1):
            copy_area[r][c] = tmp[r][c]


def rotateByOrder(orders):
    global k
    for o in orders:
        rotate(o)


for orders in permutations(range(k), k):
    copy_area = [row[:] for row in area]
    rotateByOrder(orders)
    answer = min(answer, findMinimum(copy_area))

print(answer)
