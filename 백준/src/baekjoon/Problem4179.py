import sys
from queue import Queue

input = sys.stdin.readline

R, C = map(int, input().split())
moves = [(1, 0), (-1, 0), (0, 1), (0, -1)]
map_ = [list(map(str, input().strip('\n'))) for _ in range(R)]
isVisited = [[-1 for _ in range(C)] for _ in range(R)]


def bfs(sr, sc):
    global map_, isVisited, fires, R, C

    q = Queue()
    q.put((sr, sc, 'J'))
    isVisited[sr][sc] = 0

    while not fires.empty():
        fire = fires.get()
        q.put(fire)

    while not q.empty():
        cur = q.get()
        curType = cur[2]

        cr = cur[0]
        cc = cur[1]

        if curType == 'J' and map_[cr][cc] == 'F':
            continue

        for i in range(4):
            nr = cr + moves[i][0]
            nc = cc + moves[i][1]

            if curType == 'J':
                if isOutOfBound(nc, nr):
                    print(isVisited[cr][cc] + 1)
                    exit(0)

                if isVisited[nr][nc] != -1 or map_[nr][nc] == '#' or map_[nr][nc] == 'F':
                    continue

                isVisited[nr][nc] = isVisited[cr][cc] + 1
                q.put((nr, nc, 'J'))
            else:
                if isOutOfBound(nc, nr):
                    continue

                if map_[nr][nc] == '#' or map_[nr][nc] == 'F':
                    continue

                map_[nr][nc] = 'F'
                q.put((nr, nc, 'F'))

    print('IMPOSSIBLE')


def isOutOfBound(nc, nr):
    global R, C
    return nr < 0 or nc < 0 or nc >= C or nr >= R


sr, sc = 0, 0
fires = Queue()
for r in range(R):
    for c in range(C):
        if map_[r][c] == 'J':
            sr, sc = r, c
            continue
        if map_[r][c] == 'F':
            fires.put((r, c, 'F'))

bfs(sr, sc)
