import sys
from collections import deque
from itertools import permutations

moves = [(1, 0), (-1, 0), (0, 1), (0, -1)]
input = sys.stdin.readline


def bfs(start, targets):
    global R, C, moves, area, weights
    max_size = R * C + 1
    q = deque()
    rrr, ccc = start
    q.append((rrr, ccc, 0))
    visited = [0 for _ in range(R)]
    visited[rrr] |= 1 << ccc

    while q:
        cr, cc, distance = q.popleft()

        if distance > max_size:
            break

        if not targets:
            break

        if targets.__contains__((cr, cc)):
            weights[rrr][ccc][cr][cc] = distance

        for i in range(4):
            nr = cr + moves[i][0]
            nc = cc + moves[i][1]

            if nr < 0 or nc < 0 or nr >= R or nc >= C:
                continue
            if visited[nr] & (1 << nc) != 0 or area[nr][nc] == 'x':
                continue

            visited[nr] |= (1 << nc)
            q.append((nr, nc, distance + 1))


while True:
    C, R = map(int, input().split())
    if (R, C) == (0, 0):
        break

    area = [list(map(str, input().strip('\n'))) for _ in range(R)]

    robots = deque()
    targets = deque()
    for r in range(R):
        for c in range(C):
            if area[r][c] == 'o':
                robots.append((r, c))
            if area[r][c] == '*':
                targets.append((r, c))

    targets.appendleft(robots[0])
    weights = [[[[-1 for _ in range(C)] for _ in range(R)] for _ in range(C)] for _ in range(R)]
    for t in targets:
        copy_targets = [row[:] for row in targets]
        copy_targets.remove(t)
        bfs(t, copy_targets)

    rr_, rc_ = targets.popleft()
    answer = sys.maxsize
    cannot_find = False
    for order in permutations(targets, len(targets)):
        rr, rc = rr_, rc_
        tmp = 0
        for dr, dc in order:
            weight = weights[rr][rc][dr][dc]
            if weight == -1:
                cannot_find = True
                break
            tmp += weight
            rr, rc = dr, dc

        if cannot_find:
            break
        answer = min(answer, tmp)

    if cannot_find:
        print(-1)
    else:
        print(answer)
