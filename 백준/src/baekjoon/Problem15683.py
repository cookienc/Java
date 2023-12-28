import sys
from copy import deepcopy

input = sys.stdin.readline

watches = [(-1, 0), (0, -1), (1, 0), (0, 1)]


def countCannotWatch(directions):
    global area, cctvs
    copy_area = deepcopy(area)

    for i in range(len(directions)):
        cctv = cctvs[i]
        r = cctv[0]
        c = cctv[1]
        type = cctv[2]
        direction = directions[i]

        if type == 1:
            watch(r, c, copy_area, direction)
            continue
        if type == 2:
            watch(r, c, copy_area, direction)
            watch(r, c, copy_area, (direction + 2) % 4)
            continue
        if type == 3:
            watch(r, c, copy_area, direction)
            watch(r, c, copy_area, (direction + 1) % 4)
            continue
        if type == 4:
            watch(r, c, copy_area, direction)
            watch(r, c, copy_area, (direction + 1) % 4)
            watch(r, c, copy_area, (direction + 2) % 4)
            continue
        if type == 5:
            watch(r, c, copy_area, direction)
            watch(r, c, copy_area, (direction + 1) % 4)
            watch(r, c, copy_area, (direction + 2) % 4)
            watch(r, c, copy_area, (direction + 3) % 4)
            continue

    count = 0
    for i in range(R):
        for j in range(C):
            if copy_area[i][j] == 0:
                count += 1

    return count


def watch(sr, sc, area, direction):
    global R, C, watches
    nr = sr
    nc = sc
    while True:
        nr += watches[direction][0]
        nc += watches[direction][1]

        if nr < 0 or nc < 0 or nr >= R or nc >= C:
            break

        if area[nr][nc] == 6:
            break

        if area[nr][nc] == 0:
            area[nr][nc] = '#'


R, C = map(int, input().split())
area = [list(map(int, input().split())) for _ in range(R)]
cctvs = []
answer = 0
for r in range(R):
    for c in range(C):
        if 1 <= area[r][c] <= 5:
            cctvs.append((r, c, area[r][c]))
        if area[r][c] == 0:
            answer += 1

cctv_size = len(cctvs)
d = 4 ** cctv_size

for i in range(d):
    tmp = i
    directions = []
    for j in range(cctv_size):
        directions.append(tmp % 4)
        tmp //= 4

    answer = min(countCannotWatch(directions), answer)

print(answer)
