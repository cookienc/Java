import sys
from queue import PriorityQueue

input = sys.stdin.readline
C, R = map(int, input().split())
move = [(1, 0), (-1, 0), (0, 1), (0, -1)]


def bfs(sc, sr):
    global maxSize, map_, cnt, C, R
    cnt += 1

    pq = PriorityQueue()
    isVisited[sc][sr] = True
    pq.put((sc, sr))
    size = 0
    while not pq.empty():
        cur = pq.get()
        size += 1
        for i in range(4):
            nc = cur[0] + move[i][0]
            nr = cur[1] + move[i][1]

            if nr < 0 or nc < 0 or nr >= R or nc >= C:
                continue
            if isVisited[nc][nr]:
                continue
            if map_[nc][nr] == 0:
                continue

            isVisited[nc][nr] = True
            pq.put((nc, nr))
    maxSize = max(maxSize, size)


map_ = [list(map(int, input().split())) for _ in range(C)]

maxSize = 0
cnt = 0
isVisited = [[False for _ in range(R)] for _ in range(C)]

q = PriorityQueue()
for c in range(C):
    for r in range(R):
        if not isVisited[c][r] and map_[c][r] == 1:
            bfs(c, r)

print(cnt)
print(maxSize)
