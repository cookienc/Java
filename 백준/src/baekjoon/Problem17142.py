import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline
N, M = map(int, input().split())
area = []
virus = []
blanks = 0
for r in range(N):
    a = list(map(int, input().split()))
    for c in range(N):
        if a[c] == 2:
            virus.append((r, c))
        if a[c] == 0:
            blanks += 1
    area.append(a)
virus_pair = combinations(virus, M)

answer = sys.maxsize
moves = [(1, 0), (-1, 0), (0, 1), (0, -1)]


def bfs(area_, virus_, blanks_):
    global N, answer
    q = deque()
    visited = [[False for _ in range(N)] for _ in range(N)]
    for r, c in virus_:
        q.append((r, c, 0))
        visited[r][c] = True
        area_[r][c] = 0

    tmp = -9
    while q:
        cr, cc, d = q.popleft()

        for dr, dc in moves:
            nr = cr + dr
            nc = cc + dc

            if nr < 0 or nc < 0 or nr >= N or nc >= N:
                continue
            if visited[nr][nc] or area_[nr][nc] == -1:
                continue
            visited[nr][nc] = True
            if area_[nr][nc] == -2:
                area_[nr][nc] = -3
            else:
                area_[nr][nc] = d + 1
                blanks_ -= 1
            q.append((nr, nc, d + 1))

    for r in range(N):
        for c in range(N):
            if area_[r][c] == -9:
                return
            tmp = max(tmp, area_[r][c])

    answer = min(tmp, answer)


for vp in virus_pair:
    copy_area = []
    for r in range(N):
        copy_area.append([])
        for c in range(N):
            if area[r][c] == 1:
                copy_area[r].append(-1)
            elif area[r][c] == 2:
                copy_area[r].append(-2)
            else:
                copy_area[r].append(-9)

    bfs(copy_area, vp, blanks)

print(answer if answer != sys.maxsize else -1)
