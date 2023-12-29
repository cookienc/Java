import sys
from collections import deque
from itertools import permutations

input = sys.stdin.readline
moves = [(1, 0, 0), (-1, 0, 0), (0, 1, 0), (0, -1, 0), (0, 0, 1), (0, 0, -1)]

maze = [[list(map(int, input().split())) for _ in range(5)] for _ in range(5)]
maxTries = 4 ** 5

answer = 5 * 5 * 5 + 1


def dfs(_maze, depth):
    if depth == 5:
        bfs(_maze)
        return

    for r in range(4):
        if _maze[0][0][0]:
            dfs(_maze, depth + 1)
        _maze[depth] = rotate(_maze[depth])


def bfs(_maze):
    global answer
    q = deque()
    if not _maze[0][0][0] or not _maze[4][4][4]:
        return

    q.append((0, 0, 0, 0))
    visited = [[[False for _ in range(5)] for _ in range(5)] for _ in range(5)]
    visited[0][0][0] = True

    while q:
        cr, cc, cz, cd = q.popleft()

        if (cr, cc, cz) == (4, 4, 4):
            if cd == 12:
                print(12)
                exit(0)

            answer = min(answer, cd)
            break

        for d in range(6):
            nr = cr + moves[d][0]
            nc = cc + moves[d][1]
            nz = cz + moves[d][2]
            if nr < 0 or nc < 0 or nz < 0 or nr >= 5 or nc >= 5 or nz >= 5:
                continue

            if visited[nr][nc][nz] or not _maze[nr][nc][nz]:
                continue

            visited[nr][nc][nz] = True
            q.append((nr, nc, nz, cd + 1))


def rotate(to_):
    from_ = [[0 for _ in range(5)] for _ in range(5)]
    for r in range(5):
        for c in range(5):
            from_[c][4 - r] = to_[r][c]
    return from_


for p in permutations([0, 1, 2, 3, 4], 5):
    curMaze = []
    for i in range(5):
        curMaze.append(maze[p[i]])

    dfs(curMaze, 0)

print(answer if answer != 5 * 5 * 5 + 1 else -1)
