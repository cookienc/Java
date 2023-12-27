import sys
from copy import deepcopy
from itertools import product

input = sys.stdin.readline

R, C = map(int, input().split())
area = [list(map(int, input().split())) for _ in range(R)]
cctvs = []
max = 0
for r in range(R):
    for c in range(C):
        if 1 <= area[r][c] <= 5:
            cctvs.append((r, c, area[r][c]))
        if area[r][c] == 0:
            max += 1

cctv_size = len(cctvs)
directions = product([1, 2, 3, 4], repeat=cctv_size)
answer = max


def watch_right(sr, sc):
    global tmp, C
    for c in range(sc + 1, C):
        if copy_area[sr][c] == 6:
            break
        if copy_area[sr][c] == 0:
            copy_area[sr][c] = '#'
            tmp = tmp - 1


def watch_down(sr, sc):
    global tmp, R
    for r in range(sr + 1, R):
        if copy_area[r][sc] == 6:
            break
        if copy_area[r][sc] == 0:
            copy_area[r][sc] = '#'
            tmp = tmp - 1


def watch_left(sr, sc):
    global tmp
    for c in range(sc - 1, -1, -1):
        if copy_area[sr][c] == 6:
            break
        if copy_area[sr][c] == 0:
            copy_area[sr][c] = '#'
            tmp = tmp - 1


def watch_up(sr, sc):
    global tmp
    for r in range(sr - 1, -1, -1):
        if copy_area[r][sc] == 6:
            break
        if copy_area[r][sc] == 0:
            copy_area[r][sc] = '#'
            tmp = tmp - 1


for direction in directions:
    copy_area = deepcopy(area)
    tmp = max
    for i in range(cctv_size):
        cctv = cctvs[i]
        sr = cctv[0]
        sc = cctv[1]
        type = cctv[2]
        cur_d = direction[i]

        if type == 1:
            # 위
            if cur_d == 1:
                watch_up(sr, sc)
            # 왼
            if cur_d == 2:
                watch_left(sr, sc)
            # 아래
            if cur_d == 3:
                watch_down(sr, sc)
            # 오
            if cur_d == 4:
                watch_right(sr, sc)
        if type == 2:
            if cur_d % 2 == 0:
                watch_up(sr, sc)
                watch_down(sr, sc)
            else:
                watch_left(sr, sc)
                watch_right(sr, sc)
        if type == 3:
            if cur_d == 1:
                watch_up(sr, sc)
                watch_right(sr, sc)
            if cur_d == 2:
                watch_up(sr, sc)
                watch_left(sr, sc)
            if cur_d == 3:
                watch_left(sr, sc)
                watch_down(sr, sc)
            if cur_d == 4:
                watch_down(sr, sc)
                watch_right(sr, sc)
        if type == 4:
            if cur_d == 1:
                watch_right(sr, sc)
                watch_up(sr, sc)
                watch_left(sr, sc)
            if cur_d == 2:
                watch_up(sr, sc)
                watch_left(sr, sc)
                watch_down(sr, sc)
            if cur_d == 3:
                watch_left(sr, sc)
                watch_down(sr, sc)
                watch_right(sr, sc)
            if cur_d == 4:
                watch_down(sr, sc)
                watch_right(sr, sc)
                watch_up(sr, sc)
        if type == 5:
            watch_left(sr, sc)
            watch_down(sr, sc)
            watch_right(sr, sc)
            watch_up(sr, sc)
    answer = min(answer, tmp)
print(answer)
